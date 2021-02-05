package de.tomgrill.gdxtesting.Screens;

import com.team5.game.MainGame;
import com.team5.game.Screens.LoseScreen;
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
public class LoseScreenTests {

    @Spy
    MainGame game = mock(MainGame.class, "game");

    @Spy
    LoseScreen lose = mock(LoseScreen.class, "lose");

    @Test
    public void emptyTest(){
        assertNotNull("passes if main has been instantiated",lose);
    }

    @Test
    public void openTest(){
        game.setScreen(lose);
        try {
            Mockito.verify(game).setScreen(lose); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if game successfully sets the LoseScreen as its screen");
        }

    }

}
