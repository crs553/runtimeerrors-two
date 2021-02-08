
package com.team5.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.team5.game.MainGame;
import com.team5.game.Tools.Constants;
import com.team5.game.Tools.CustomCamera;

public class MainMenuScreen implements Screen {

    /*
    MainMenuScreen is the class that renders the main menu
    and transfers over to the PlayScreen or quits the application
     */

    //Main Game Reference
    MainGame game;

    //added by runtime errors
    int currentMuteButton = 0;

    //Menu buttons
    ImageButton playButton;
    ImageButton quitButton;
    ImageButton levelButton;
    ImageButton muteButton;

    Stage stage;

    Texture title;

    //Audio
    Sound click = Gdx.audio.newSound(Gdx.files.internal("Audio/Sound Effects/click.wav"));

    //Menu positions
    Vector2 playPos = new Vector2(Constants.CAMERA_WIDTH/2-48, 65);
    Vector2 quitPos = new Vector2(Constants.CAMERA_WIDTH/2-48, 5);
    Vector2 levelPos = new Vector2(Constants.CAMERA_WIDTH/2-48, 35);
    Vector2 titlePos = new Vector2(Constants.CAMERA_WIDTH/2-120, 105);

    //Colliders
    World world;
    Box2DDebugRenderer b2dr;
    int noNPCs = 75;

    //Reference
    CustomCamera camera;

    public MainMenuScreen (final MainGame game){

        this.game = game;
        title = new Texture("Sprites/Menu/Title.png");

        //Collisions
        world = new World(new Vector2(0, 0), true);
        b2dr = new Box2DDebugRenderer();

        //Camera
        camera = new CustomCamera();

        //Buttons
        setupButtons();

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(Gdx.graphics.getDeltaTime());

        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        b2dr.render(world, new Matrix4(camera.cam.combined));

        game.batch.setProjectionMatrix(camera.cam.combined);

        game.batch.begin();
        game.batch.draw(title, titlePos.x, titlePos.y);
        game.batch.end();

        stage.act(delta);
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        camera.port.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        this.dispose();
        stage.dispose();
        world.dispose();
        b2dr.dispose();
        click.dispose();
    }

    //Custom functions from here

    public void update(float delta){
        world.step(1/60f, 6, 2);

        //Updates Camera
        camera.update();
    }

    // Level addition
    void setupButtons(){
        stage = new Stage(camera.port);
        Gdx.input.setInputProcessor(stage);

        //added by runtime errors
        //sets up the mute button textures
        if(Constants.volumeMultipler == 1) {
            currentMuteButton = 0;
        } else {
            currentMuteButton = 2;
        }
        Image[] muteButtons = {new Image(new Texture("Sprites/Menu/soundon.png")),
                new Image(new Texture("Sprites/Menu/soundon_selected.png")),
                new Image(new Texture("Sprites/Menu/soundoff.png")),
                new Image(new Texture("Sprites/Menu/soundoff_selected.png"))
        };
        //modified by runtime errors
        playButton = new ImageButton(new Image(new Texture("Sprites/Menu/PlayOff.png")).getDrawable());
        levelButton = new ImageButton(new Image(new Texture("Sprites/Menu/LevelOff.png")).getDrawable());
        quitButton = new ImageButton(new Image(new Texture("Sprites/Menu/ExitOff.png")).getDrawable());
        muteButton = new ImageButton(muteButtons[currentMuteButton].getDrawable());

        playButton.setPosition(playPos.x, playPos.y);
        levelButton.setPosition(levelPos.x, levelPos.y);
        quitButton.setPosition(quitPos.x, quitPos.y);

        playButton.setSize(90, 30);
        levelButton.setSize(90, 30);
        quitButton.setSize(90, 30);
        muteButton.setSize(24,24);

        playButton.getStyle().imageOver = new Image(new Texture("Sprites/Menu/PlayOn.png")).getDrawable();
        levelButton.getStyle().imageOver = new Image(new Texture("Sprites/Menu/LevelOn.png")).getDrawable();
        quitButton.getStyle().imageOver = new Image(new Texture("Sprites/Menu/ExitOn.png")).getDrawable();
        muteButton.getStyle().imageOver = muteButtons[currentMuteButton+1].getDrawable();

        stage.addActor(playButton);
        stage.addActor(levelButton);
        stage.addActor(quitButton);
        stage.addActor(muteButton);

        //added by runtime errors
        //changes the volume and mute button texture on click
        muteButton.addListener(new ClickListener() {
            public void clicked(InputEvent event,float x,float y) {
                if(currentMuteButton <= 1) {
                    currentMuteButton = 2;
                } else {
                    currentMuteButton = 0;
                }
                if(Constants.volumeMultipler == 1) {
                    Constants.volumeMultipler = 0;
                } else {
                    Constants.volumeMultipler = 1;
                }
                setupButtons();
            }
        });


        // Load screen added by Runtime Errors Team 25
        playButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                click.play(0.5f*Constants.volumeMultipler, 1.5f, 0);
                game.setScreen(new LoadScreen(game));
            }
        });

        // Level screen added by Runtime Errors Team 25
        levelButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                click.play(0.5f*Constants.volumeMultipler, 1.5f, 0);
                game.setScreen(new LevelScreen(game));
            }
        });

        quitButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                click.play(0.5f*Constants.volumeMultipler, 1.5f, 0);
                Gdx.app.exit();
            }
        });
    }
}