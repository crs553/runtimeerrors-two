package com.team5.game.Sprites.Pathfinding;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.team5.game.Tools.Constants;

public class System extends Room{

    /*
    System is used for the infiltrator pathfinding so they can
    access and break the systems.
     */

    boolean broken;

    //Positioning
    Vector2 spritePosition;

    //Sprites
    public TextureRegion currentSprite;

    //On means it's not been broken yet, off means it's broken.
    public TextureRegion onSprite;
    public TextureRegion offSprite;

    public System(String tag, float x, float y, String name,
                  float spriteX, float spriteY) {
        /* Creates the systems, along with a name, tag, and position
        parameters:
            String tag gives the tag
            float x gives x coord of system location
            float y gives y coord of system location
            String name gives the name of the system
            float spriteX gives the x coord of the system sprite location
            float spriteY gives the y coord of the system sprite location
         */
        super(tag, x, y, name);
        this.spritePosition = new Vector2(spriteX * Constants.TILE_SIZE,
                spriteY * Constants.TILE_SIZE);

        setup();
    }

    public void setup(){
        /*Sets up the system sprites*/
        broken = false;

        onSprite = Constants.ATLAS.findRegion("Systems/" + tag + "On");
        offSprite = Constants.ATLAS.findRegion("Systems/" + tag + "Off");

        currentSprite = onSprite;
    }

    //To be called every frame to draw the system sprites
    public void draw(SpriteBatch batch){
        /*draws the system sprites in the window*/
        if (broken){
            currentSprite = offSprite;
        }
        batch.draw(currentSprite, spritePosition.x, spritePosition.y);
        batch.draw(new Texture("Sprites/Minimap/Cursor.png"), x-10, y-10);
    }


    public void destroy(){
        /*destroy function is called when the infiltrator breaks the system*/
        broken = true;
    }

    public boolean getBroken(){
        /*get method for broken
        returns:
            boolean broken, which specifies if the system is broken
         */
        return broken;
    }
}
