package de.tomgrill.gdxtesting.Screens;

import com.badlogic.gdx.Gdx;
import com.team5.game.MainGame;
import com.team5.game.Screens.LevelScreen;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoAssertionError;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(GdxTestRunner.class)
public class LevelScreenTests {

    MainGame game = mock(MainGame.class, "game");

    @Spy
    LevelScreen level = mock(LevelScreen.class, "level");

    @Test
    public void emptyTest(){
        assertNotNull("passes if main has been instantiated",level);
    }

    @Test
    public void openTest(){
        game.setScreen(level);
        try {
            Mockito.verify(game).setScreen(level); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if game successfully sets the level as its screen");
        }

    }
}
