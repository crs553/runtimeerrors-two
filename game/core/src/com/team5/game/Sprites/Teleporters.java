package com.team5.game.Sprites;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.team5.game.Screens.PlayScreen;
import com.team5.game.Sprites.Animation.AnimatedDrawable;
import com.team5.game.Tools.Constants;

import java.util.Hashtable;

public class Teleporters {

    /*
    Teleporters sets up all of the teleporters and opens the minimap
    if clicked.
     */

    //Screen Reference
    PlayScreen screen;

    //Images
    ImageButton teleporter;
    Image outline;
    Image base;

    //Animation
    AnimatedDrawable teleIdle;

    //Position array
    Hashtable<String, Vector2> positions;

    //Positions of each teleporter
    Vector2 PQPosition = new Vector2(25*Constants.TILE_SIZE, 69*Constants.TILE_SIZE);
    Vector2 infirmaryPosition = new Vector2(90*Constants.TILE_SIZE, 89*Constants.TILE_SIZE);
    Vector2 northWingPosition = new Vector2(53*Constants.TILE_SIZE, 82*Constants.TILE_SIZE);
    Vector2 brigPosition = new Vector2(29*Constants.TILE_SIZE, 90*Constants.TILE_SIZE);
    Vector2 enginePosition = new Vector2(81*Constants.TILE_SIZE, 42*Constants.TILE_SIZE);

    public Teleporters(PlayScreen screen){
        /*creates the teleporters
        parameters:
            PlayerScreen screen gives the current screen
         */
        this.screen = screen;

        teleIdle = new AnimatedDrawable("idle", "Teleporter/Idle", 1f);
        outline = new Image(Constants.ATLAS.findRegion("Teleporter/Outline"));
        positions = new Hashtable<>();

        setup();
    }

    void setup(){
        /*instantatiates all the teleporters*/
        addTeleporter("PQ", PQPosition);
        addTeleporter("infirmary", infirmaryPosition);
        addTeleporter("north wing", northWingPosition);
        addTeleporter("brig", brigPosition);
        addTeleporter("engine", enginePosition);
    }


    void addTeleporter(String key, Vector2 pos){
        /*Adds a new teleporter to the PlayScreen stage
        parameters:
            String key is for the dictionary of teleporters
            Vector2 pos give the position of the teleporter on the minimap
         */
        positions.put(key, pos);

        teleporter = new ImageButton(new Image(Constants.ATLAS.findRegion("Empty")).getDrawable());
        base = new Image(teleIdle);

        //The 8s are to make the hitbox bigger
        teleporter.setPosition(pos.x - 4, pos.y - 4);
        teleporter.setSize(Constants.TILE_SIZE + 8, Constants.TILE_SIZE + 8);

        base.setPosition(pos.x, pos.y);

        teleporter.getStyle().imageOver = outline.getDrawable();

        teleporter.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                /*turns the map on*/
                screen.minimapOn();
            }
        });
        screen.stage.addActor(base);
        screen.stage.addActor(teleporter);
    }

    //added by runtime errors
    public boolean updateTeleporterAbility(boolean[] abilitiesActive) {
        /*turns the minimap on if the wrist teleport ability is on
        parameters:
            boolean[] abilitiesActive gives the array of what ability is on
        returns:
            boolean true if ability on, else false
         */
        if(abilitiesActive[2]) {
            screen.minimapOn();
            return true;
        } else {
            return false;
        }

    }

    public Vector2 getTeleporter(String key){
        /* getter for the teleporter position
        parameter:
            String key is the teleporter key for the hashtable
        return:
            int pos gives the position of the teleporter on the minimap
         */
        return positions.get(key);
    }

}
