package com.team5.game.Environment;

import com.badlogic.gdx.math.Vector2;
import com.team5.game.Tools.Constants;

public class Brig {

    /*
    Brig is used to teleport the infiltrators to the brig when they're caught.
     */

    //The original position of the first caught infiltrator.
    Vector2 basePosition = new Vector2(7.5f, 94.5f);

    //The distance between each cell in the brig, so they fill in from the left.
    int xOffset = 3;

    public int prisoners = 0;

    //runtimeErrors addition
    private boolean moreThanEightCaught = false;

    int level;

    public Brig(int level){
        /*creates the brig object to deal with captured infiltrators
        parameters:
            int level, which gives the difficulty level
         */
        this.level = level;
    }

    public Vector2 imprison(){
        /* called whenever an infiltrator is caught and moves the to the brig
        returns:
            Vector2 object giving the coordinates to move the infiltrator to.
         */



        //edit added by runtime errors
        // to deal with more than 8 infiltrators
        Vector2 position;
        if(prisoners > 8) {
            moreThanEightCaught = true;
        }
        if(moreThanEightCaught) {
             position = new Vector2((basePosition.x + (xOffset*prisoners-8))
                            * Constants.TILE_SIZE, basePosition.y* Constants.TILE_SIZE);
        } else {
            position = new Vector2((basePosition.x + (xOffset * prisoners))
                    * Constants.TILE_SIZE, basePosition.y * Constants.TILE_SIZE);
        }
        prisoners++;
        java.lang.System.out.println("Brig Imprison : "+ prisoners);
        return position;
    }

    //Returns whether or not all the infiltrators have been caught.
    public boolean allCaught(){
        /* indicates whether all infiltrators are caught
        returns:
        boolean, true if all infiltrators are caught, false otherwise
         */
        if(level < 3) {
            return prisoners >= 10;
        } else {
            return prisoners >= 8;
        }
    }
    public int getPrisoners(){
        /*gives the count of infiltrators caught
        returns:
            int giving the number of infiltrators caught
         */
        return prisoners;
    }

}
