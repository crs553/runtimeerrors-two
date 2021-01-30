package com.team5.game.Sprites.Pathfinding;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.graphics.Texture;
import com.team5.game.MainGame;


//Entire class created by runtime errors


public class Trap extends Rectangle {

    Texture defaultSkin = new Texture("Sprites/TexturePack/motion_sensor.png");
    Texture alertSkin = new Texture("Sprites/TexturePack/motion_sensor_alert.png");

    boolean exists = true;
    boolean alerted = false;

    public Trap(float x, float y) {
        super(x,y,48,48);
    }
    public boolean shouldDraw(boolean mapVisible) {
        if(exists && !mapVisible) {
            return true;
        } else {
            return false;
        }
    }
    public void render(SpriteBatch batch) {
        if (alerted) {
            batch.draw(alertSkin, super.x, super.y);
        } else {
            batch.draw(defaultSkin,super.x,super.y);
        }
    }

    public boolean checkIfOver(int abilityTimeLeft,boolean[] abilitiesActive) {
        if (abilitiesActive[4]) {
            if (abilityTimeLeft <= 1) {
                exists = false;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
