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
    }

    //Called when an infiltrator finishes breaking a systems
    public void breakSystem(){
        systemsBroken++;
        Gdx.app.log("Systems broken", String.valueOf(systemsBroken));
    }

    //Returns true when the systems broken is bigger than or equal to the max number of systems
    public boolean allSystemsBroken(){
        return (systemsBroken>=maxSystems);
    }

}
