package com.team5.game.Tools;

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
    int noNPCs;
    int noInfiltrators = 8;

    boolean motionTrapExists = false;
    Trap motionTrap;


    public GameController(MainGame game, PlayScreen screen){
        this.game = game;

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
        brig = new Brig();
        systemChecker = new SystemChecker();

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
        for (int i = 0; i < noInfiltrators; i++) {
            System node = graph.getRandomSystem();
            Infiltrator npc = new Infiltrator(game, screen, this, screen.getWorld(), graph,
                    node, new Vector2(node.getX(), node.getY()));
            infiltrators.add(npc);
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

    public void dispose(){
        for (NPC npc : npcs){
            npc.dispose();
        }
        for (Infiltrator bad : infiltrators){
            bad.dispose();
        }
    }

}
