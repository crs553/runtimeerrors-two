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
    public int currentAbility = 100; //index for arrays below, 100 means none active
    public boolean[] abilityAvailable = new boolean[] {true,true,true,true,true}; //(One use)
    public boolean[] abilityCurrentlyActive = new boolean[] {false,false,false,false,false};
    int abilityTimeLeft = 500;



    public Player(MainGame game, World world){
        /*
        Instantiates Player
        param:
            MainGame game
            World world
         */
        this.world = world;

        health = new Health(game, this);
        b2body = charCollider.defineCollider(world, new Vector2(x, y), size);
        setupAnimations();
    }

    public void update(){
        /*
        Update is called every frame to move and animate the player
         */
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

    public void setupAnimations(){
        /*
        Sets up animator and all animations needed for the player
         */
        anim = new Animator("idle", "Player/Idle");
        anim.add("run", "Player/Run");
        facingRight = true;
        currentSprite = anim.getSprite();
    }

    Vector2 checkInputs() {
        /*
        Checks for keyboard input and produces a Vector2 based on that input
         */
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
    private void activateAbility(int abilityNum) {
        /*
        Allows for activation of ability
        Created by Runtime Errors
        If current ability is 100 not ability is active
         */
        if(currentAbility == 100) {
            if(abilityAvailable[abilityNum]) {
                currentAbility = abilityNum;
                abilityAvailable[abilityNum] = false;
                abilityCurrentlyActive[abilityNum] = true;
            }
        }
    }

    public void deactivateTeleportAbility() {
        /*
        Deactivates teleport ability and no ability is active
         */
        abilityCurrentlyActive[2] = false;
        currentAbility = 100;
        abilityTimeLeft = 500;
    }

    //Deciding which animation will be played each frame based on input
    void handleAnimations(Vector2 direction){
        /*
        Decides which animation for each frame based on input
        param:
            Vector2 Direction
         */
        if (direction.isZero(0.01f)){
            b2body.setLinearVelocity(0f, 0f);
            anim.play("idle");
        } else {
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

    public void updatePosition(Vector2 target){
        /*
        updates position after a teleport
        param:
            Vector2 target
         */
        b2body.setTransform(target, 0);
        x = b2body.getPosition().x;
        y = b2body.getPosition().y;
    }

    public int getHealth(){
        /*
        Getter for health
        return:
            health.gethealth()
         */
        return health.getHealth();
    }

    // SetHealth added by Runtime Errors
    public void setHealth(int newHealth){
        /*
        Health setter
        param:
            int newHealth
         */
        health.setHealth(newHealth);
    }
    //getAbilities adde by Runtime Errors
    public boolean[] getAbilities(){
        /*
        getter for saving and loading abilities
        return:
            ability available
         */
        return abilityAvailable;
    }
    // setAbilities added by Runtime Errors
    public void setAbilities(boolean[] abilitiesSaved){
        /*
        setter for saving and loading abilities
        param:
            boolean abilitiesSaved
         */
        abilityAvailable = abilitiesSaved;
    }

    public void draw(SpriteBatch batch){
        /*
        Draws the player
        params:
            SpriteBatch batch
         */
        batch.draw(currentSprite, x, y);
        if (health.getHealing()) {
            health.draw(batch, x-2, y-2);
        }
    }
    public boolean shouldCreateMotionTrap(boolean motionTrapExists) {
        /*
        Checks if motion trap can be created
        param:
            boolean motionTrapExists
        return:
            true
            false
         */
        if(abilityCurrentlyActive[4] && !motionTrapExists) {
            return true;
        } else {
            return false;
        }
    }

}
