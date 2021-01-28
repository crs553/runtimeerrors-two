package com.team5.game.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.team5.game.MainGame;
import com.team5.game.Sprites.Animation.Animator;
import com.team5.game.Sprites.Collisions.CharacterCollider;
import com.team5.game.Sprites.Health.Health;
import com.team5.game.Tools.Constants;

public class Player extends Sprite {

    /*
    Player contains all of the information regarding
    the player as well as the methods used to control them.
     */

    //Collider
    public World world;
    public Body b2body;
    int size = Constants.TILE_SIZE;
    CharacterCollider charCollider = new CharacterCollider();

    //Animations
    Animator anim;

    public TextureRegion currentSprite;

    boolean facingRight;

    //Inputs
    private int yInput;
    private int xInput;
    private Vector2 direction;


    //Movement (edited by Team 25)
    float speed = 100;
    float sprintSpeed = 200;
    float normalSpeed = 100;

    public float x = 50 * Constants.TILE_SIZE;
    public float y = 95 * Constants.TILE_SIZE;

    //Health
    Health health;

    // ADDED BY SECOND DEVELOPERS (RUNTIME ERRORS, TEAM 25)
    //Player Abilities
    //ability at index 0 is system invulnerability - goes to keyboard num 1
    //ability at index 1 is sprint - goes to keyboard num 2
    //ability at index 2 is teleport - goes to keyboard num 3
    //ability at index 3 is slow infiltrators - goes to keyboard num 4
    private int currentAbility = 100; //index for arrays below, 100 means none active
    private boolean[] abilityAvailable = new boolean[] {true,true,true,true,true}; //(One use)
    public boolean[] abilityCurrentlyActive = new boolean[] {false,false,false,false,false};
    int abilityTimeLeft = 500;


    //To instantiate the player
    public Player(MainGame game, World world){
        this.world = world;

        health = new Health(game, this);
        b2body = charCollider.defineCollider(world, new Vector2(x, y), size);
        setupAnimations();
    }

    //To be called every frame to move and animate the player.
    public void update(){
        handleAnimations(checkInputs());
        health.update();

        //Runtime Errors edit
        //Manages ability cooldown
        if(currentAbility == 2) {
            abilityTimeLeft = 1;
        }
        if(currentAbility != 100) {
            if (abilityTimeLeft > 0) {
                abilityTimeLeft--;
            } else {
                abilityTimeLeft = 500;
                // Checks for sprint ability to reset speed
                if (currentAbility == 1) {
                    speed = normalSpeed;
                }
                abilityCurrentlyActive[currentAbility] = false;
                currentAbility = 100;

            }
        }
    }

    //Setting up the animator as well as all the animations.
    public void setupAnimations(){
        anim = new Animator("idle", "Player/Idle");
        anim.add("run", "Player/Run");
        facingRight = true;
        currentSprite = anim.getSprite();
    }

    //Checks the keyboard inputs and produces a Vector2 accordingly
    Vector2 checkInputs() {
        xInput = 0;
        yInput = 0;

        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)){
            yInput++;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)){
            yInput--;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)){
            xInput--;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)){
            xInput++;
        }

        //Runtime errors adding ability buttons (number keys)
        if (Gdx.input.isKeyPressed(Input.Keys.NUM_1) && abilityAvailable[0] && !abilityCurrentlyActive[0]) {
            activateAbility(0);
        } else if (Gdx.input.isKeyPressed(Input.Keys.NUM_2) && abilityAvailable[1] && !abilityCurrentlyActive[1]){
            // Team25 - Sets speed to sprint speed due to sprint ability used
            speed = sprintSpeed;
            activateAbility(1);
        } else if (Gdx.input.isKeyPressed(Input.Keys.NUM_3) && abilityAvailable[2] && !abilityCurrentlyActive[2]){
            activateAbility(2);
        } else if (Gdx.input.isKeyPressed(Input.Keys.NUM_4) && abilityAvailable[3] && !abilityCurrentlyActive[3]) {
            activateAbility(3);
        } else if (Gdx.input.isKeyPressed(Input.Keys.NUM_5) && abilityAvailable[4] && !abilityCurrentlyActive[4]) {
            activateAbility(4);
        }


        return new Vector2(xInput * speed, yInput * speed);
    }
    //Created by Runtime Errors
    //Activates the abilities
    private void activateAbility(int abilityNum) {
        System.out.print("activate" + abilityNum);
        if(currentAbility == 100) {
            if(abilityAvailable[abilityNum]) {
                currentAbility = abilityNum;
                abilityAvailable[abilityNum] = false;
                abilityCurrentlyActive[abilityNum] = true;
            }
        }
    }

    public void deactivateTeleportAbility() {
        abilityCurrentlyActive[2] = false;
        currentAbility = 100;
        abilityTimeLeft = 500;
    }

    //Deciding which animation will be played each frame based on input
    void handleAnimations(Vector2 direction){
        if (direction.isZero(0.01f)){
            b2body.setLinearVelocity(0f, 0f);
            anim.play("idle");
        } else {
            System.out.println(direction);
            b2body.setLinearVelocity(direction.x, direction.y);
            anim.play("run");
        }

        x = b2body.getPosition().x;
        y = b2body.getPosition().y;

        currentSprite = anim.getSprite();

        if ((b2body.getLinearVelocity().x < 0 || !facingRight) && !anim.isFlipped()){
            anim.flip();
            facingRight = false;
        } else if ((b2body.getLinearVelocity().x > 0 || facingRight) && anim.isFlipped()){
            anim.flip();
            facingRight = true;
        }
    }

    //Used to teleport the player across the map
    public void updatePosition(Vector2 target){
        b2body.setTransform(target, 0);
        x = b2body.getPosition().x;
        y = b2body.getPosition().y;
    }

    public int getHealth(){
        return health.getHealth();
    }

    public void draw(SpriteBatch batch){
        batch.draw(currentSprite, x, y);
        if (health.getHealing()) {
            health.draw(batch, x-2, y-2);
        }
    }

}
