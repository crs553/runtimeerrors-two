package com.team5.game.Environment;

import com.badlogic.gdx.Gdx;

public class SystemChecker {

    /*
    SystemChecker counts how many systems are broken, so that
    the game can end when they have broken as many systems as needed.
     */

    int systemsBroken = 0;

    int maxSystems = 15;

    public SystemChecker(){
        /*creates system checker object*/
    }

    public void breakSystem(){
        /* keeps an integer count of the number of systems broken. Called
        * when an infiltrator finishes breaking a system*/
        systemsBroken++;
    }

    //Runtime Errors edit
    public int getSystemsBroken(){
        /*getter for the variable counting the number of systems broken
        returns:
            int that counts the num of systems broken
         */
        return (systemsBroken);
    }

    public boolean allSystemsBroken(){
        /*returns true when the system broken is bigger than or equal to the max num of systems
        returns:
            boolean value true if all systems are broken, else false.
         */
        return (systemsBroken>=maxSystems);
    }

}
