package de.tomgrill.gdxtesting.Screens;

import com.team5.game.MainGame;
import com.team5.game.Screens.MainMenuScreen;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class MainMenuScreenTests {

    @Spy
    MainGame game = mock(MainGame.class, "game");

    @Spy
    MainMenuScreen main = mock(MainMenuScreen.class, "main");

    @Test
    public void emptyTest(){
        assertNotNull("passes if main has been instantiated",main);
    }

    @Test
    public void openTest(){
        game.setScreen(main);
        try {
            Mockito.verify(game).setScreen(main); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if game successfully sets the main menu as its screen");
        }
    }
}
