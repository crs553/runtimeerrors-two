package com.team5.game.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.team5.game.MainGame;
import com.team5.game.Screens.MainMenuScreen;
import com.team5.game.Screens.PlayScreen;
import com.team5.game.Tools.CustomCamera;

public class PauseMenu {

    /*
    PauseMenu creates a pause menu that can be called upon
    in the PlayScreen class when the Escape key is pressed.
     */

    //Game Reference
    public MainGame game;

    //Camera
    public Stage stage;
    public CustomCamera camera;

    //Menu Elements
    Image pauseImage;
    ImageButton menuButton;

    // Added by Runtime Errors Team 25
    ImageButton saveButton;

    //Audio
    public Sound click = Gdx.audio.newSound(Gdx.files.internal("Audio/Sound Effects/click.wav"));

    //Element Positioning
    Vector2 pauseOffset = new Vector2(-112, -75);
    Vector2 menuOffset = new Vector2(-48, -64); // Team 25 - changed the manu layout
    Vector2 saveOffset = new Vector2(-48, -30);

    public PauseMenu(MainGame game, PlayScreen screen){
        this.game = game;
        camera = screen.camera;

        setup();
    }

    void setup(){
        stage = new Stage(camera.port);
        pauseImage = new Image(new Texture("Sprites/Menu/Pause Menu.png"));
        pauseImage.setPosition(camera.cam.position.x + pauseOffset.x,
                camera.cam.position.y + pauseOffset.y);

        menuButton = new ImageButton(new Image(new Texture("Sprites/Menu/MenuOff.png")).getDrawable());
        menuButton.setPosition(camera.cam.position.x + menuOffset.x,
                camera.cam.position.y + menuOffset.y);
        menuButton.setSize(96, 32);
        menuButton.getStyle().imageOver = new Image(new Texture("Sprites/Menu/MenuOn.png")).getDrawable();

        menuButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                click.play(0.5f, 1.5f, 0);
                game.setScreen(new MainMenuScreen(game));
            }
        });

        // Team 25 - Save button
        saveButton = new ImageButton(new Image(new Texture("Sprites/Menu/SaveOff.png")).getDrawable());
        saveButton.setPosition(camera.cam.position.x + saveOffset.x,
                camera.cam.position.y + saveOffset.y);
        saveButton.setSize(96, 32);
        saveButton.getStyle().imageOver = new Image(new Texture("Sprites/Menu/SaveOn.png")).getDrawable();

        saveButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                click.play(0.5f, 1.5f, 0);
                game.setScreen(new MainMenuScreen(game));
            }
        });

        stage.addActor(pauseImage);
        stage.addActor(menuButton);
        stage.addActor(saveButton); // Team 25 save button

    }

    public void update(){
        pauseImage.setPosition(camera.cam.position.x + pauseOffset.x,
                camera.cam.position.y + pauseOffset.y);
        menuButton.setPosition(camera.cam.position.x + menuOffset.x,
                camera.cam.position.y + menuOffset.y);

        saveButton.setPosition(camera.cam.position.x + saveOffset.x,
                camera.cam.position.y + saveOffset.y);
    }

    public void draw(float delta){
        stage.act(delta);
        stage.draw();
    }

}
