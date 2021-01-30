package com.team5.game.Sprites.Pathfinding;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.graphics.Texture;
import com.team5.game.MainGame;


//Entire class created by runtime errors


public class Trap extends Rectangle {

    private Texture defaultSkin = new Texture("Sprites/TexturePack/motion_sensor.png");
    private Texture alertSkin = new Texture("Sprites/TexturePack/motion_sensor_alert.png");

    private boolean alerted = false;

    public Trap(float x, float y) {
        super(x,y,48,48);
        this.x = x - 24;
        this.y = y - 24;
    }

    public Texture getSkin() {
        if (alerted) {
            return alertSkin;
        } else {
            return defaultSkin;
        }
    }

    public void alert() {
        alerted = true;
    }
    public void resetAlert() {
        alerted = false;
    }


}
