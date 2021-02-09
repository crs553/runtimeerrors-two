package com.team5.game.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.team5.game.Environment.Brig;
import com.team5.game.Environment.SystemChecker;
import com.team5.game.MainGame;
import com.team5.game.Screens.LoseScreen;
import com.team5.game.Screens.PlayScreen;
import com.team5.game.Sprites.Infiltrator;
import com.team5.game.Sprites.NPC;
import com.team5.game.Sprites.Pathfinding.Node;
import com.team5.game.Sprites.Pathfinding.NodeGraph;
import com.team5.game.Sprites.Pathfinding.System;
import com.team5.game.Sprites.Pathfinding.Trap;
import com.team5.game.Sprites.Player;
import com.team5.game.Sprites.Teleporters;

public class GameController {

    //References
    MainGame game;
    Player player;
    Teleporters teleporters;
    NodeGraph graph;
    Brig brig;
    SystemChecker systemChecker;

    Array<NPC> npcs;
    Array<Infiltrator> infiltrators;

    //NPC numbers
    public int noNPCs;
    public int noInfiltrators = 8;

    // Runtime Errors Team 25 - Save/Load
    Preferences prefs = Gdx.app.getPreferences("Save File");
    int savedPrisoners = prefs.getInteger("prisoners",0);;
    int savedLevel = 0;
    int savedHealth = prefs.getInteger("health",Constants.MAX_HEALTH);
    float savedPlayerX = prefs.getFloat("playerx",50 * Constants.TILE_SIZE);
    float savedPlayerY = prefs.getFloat("playery",95 * Constants.TILE_SIZE);
    int savedSysBroken = prefs.getInteger("sysBroken",0);
    boolean[] savedAbilities = new boolean[] {prefs.getBoolean("ability0",true),prefs.getBoolean("ability1",true),prefs.getBoolean("ability2",true),prefs.getBoolean("ability3",true),prefs.getBoolean("ability4",true)};

    boolean motionTrapExists = false;
    Trap motionTrap;


    public GameController(MainGame game, PlayScreen screen, boolean loadGame){
        this.game = game;

        // Runtime Errors Save/Load setting level
        if (loadGame){
            // if load is empty, returns 0, uses current level selected.
            int savedLevel = prefs.getInteger("level",0);
            if (savedLevel != 0) {
                game.setLevel(savedLevel);
            }
        }

        //runtime errors addition level setter
        int leverSetter = game.getLevel();
        if (leverSetter == 1){
            this.noNPCs = 50;
            this.noInfiltrators = 10;
        }
        else if(leverSetter == 2){
            this.noNPCs = 75;
            this.noInfiltrators = 10;
        }
        else if(leverSetter == 3){
            this.noNPCs = 100;
            this.noInfiltrators = 8;
        }


        //Player
        player = new Player(game, screen.getWorld());

        //Teleporters
        teleporters = new Teleporters(screen);

        //Checkers
        brig = new Brig(game.getLevel());


        systemChecker = new SystemChecker();

        // Runtime Errors Save/Load setting health, player coordinates and infiltrators remaining


        //NPCs
        graph = new NodeGraph();
        npcs = new Array<>();
        infiltrators = new Array<>();

        for (int i = 0; i < noNPCs; i++) {
            Node node = graph.getRandomRoom();
            NPC npc = new NPC(screen, screen.getWorld(), graph,
                    node, new Vector2(node.getX(), node.getY()));
            npcs.add(npc);
        }

        // Runtime Errors

        // Runtime Errors edit none caught infiltrators
        for (int i = 0; i < (noInfiltrators); i++) {
            System node = graph.getRandomSystem();
            Infiltrator npc = new Infiltrator(game, screen, this, screen.getWorld(), graph,
                    node, new Vector2(node.getX(), node.getY()));
            infiltrators.add(npc);
        }

        // Only runs when load is selected
        if (loadGame){
            // Runtime Errors sets caught infiltrators
            int j = 0;
            for (Infiltrator bad : infiltrators){
                if (j < savedPrisoners){
                    j += 1;
                    bad.beenCaught();
                }else{
                    break;
                }
            }

            // sets broken systems
            Array<System> systems;
            systems = new Array<>();
            systems.addAll(graph.getSystems());

            for (int i = 0; i<savedSysBroken ;i++){
                System sys = systems.random();
                if (!(sys.getBroken())){
                    sys.destroy();
                    systemChecker.breakSystem();
                }else {
                    i -= 1;
                }
            }
            // sets player used abilities, health and position
            player.setAbilities(savedAbilities);
            player.setHealth(savedHealth);
            player.updatePosition(new Vector2(savedPlayerX, savedPlayerY));

        }
    }

    public void updateTrapState(Player player) {
        if (!player.abilityCurrentlyActive[4] ) {
            motionTrapExists = false;
        }
    }

    public void draw(SpriteBatch batch){

        if(motionTrapExists) {
            batch.draw(motionTrap.getSkin(),motionTrap.x,motionTrap.y);
        }

        graph.drawSystems(batch);

        for (NPC npc : npcs){
            batch.draw(npc.currentSprite, npc.x, npc.y);
        }
        for (Infiltrator bad : infiltrators){
            batch.draw(bad.currentSprite, bad.x, bad.y);
        }
    }

    public void drawPlayer(SpriteBatch batch){
        player.draw(batch);
    }
    //edited by runtime errors
    public void update(float delta){
        if(motionTrapExists) {
            updateTrapAlert();
        }
        updateTrapState(player);
        if(player.shouldCreateMotionTrap(motionTrapExists)) {
            motionTrap = new Trap(player.x,player.y);
            motionTrapExists = true;
        }

        checkSystems();
        checkTeleports();
        //Moves player
        player.update();

        //Moves npc
        for (NPC npc : npcs){
            npc.update(delta);
        }
        for (Infiltrator bad : infiltrators){
            bad.update(delta);
        }
    }
    void checkTeleports() {
        if(teleporters.updateTeleporterAbility(player.abilityCurrentlyActive)) {
            player.deactivateTeleportAbility();
        }
    }

    //Added by runtime errors
    void updateTrapAlert() {
        boolean found = false;
        for (Infiltrator bad : infiltrators) {
            if(motionTrap.contains(bad.x,bad.y)) {
                found = true;
            }
        }
        if(found) {
            motionTrap.alert();
        } else {
            motionTrap.resetAlert();
        }
    }


    void checkSystems(){
        if (systemChecker.allSystemsBroken()){
            game.setScreen(new LoseScreen(game));
        }
    }

    public Player getPlayer(){
        return player;
    }

    public Teleporters getTeleporters(){
        return teleporters;
    }

    public SystemChecker getSystemChecker(){
        return systemChecker;
    }

    public Brig getBrig(){
        return brig;
    }

    public int getNoNPCs(){
        return noNPCs;
    }
    public int getNoInfiltrators(){
        return noInfiltrators;
    }

    public void dispose(){
        for (NPC npc : npcs){
            npc.dispose();
        }
        for (Infiltrator bad : infiltrators){
            bad.dispose();
        }
    }

}
