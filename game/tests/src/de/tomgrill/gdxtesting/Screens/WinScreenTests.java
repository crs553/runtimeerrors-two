package de.tomgrill.gdxtesting.Screens;

import com.team5.game.MainGame;
import com.team5.game.Screens.WinScreen;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class WinScreenTests {

    @Spy
    MainGame game = mock(MainGame.class, "game");

    @Spy
    WinScreen win = mock(WinScreen.class, "win");

    @Test
    public void emptyTest(){
        assertNotNull("passes if main has been instantiated",win);
    }

    @Test
    public void openTest(){
        game.setScreen(win);
        try {
            Mockito.verify(game).setScreen(win); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if game successfully sets the win screen as its screen");
        }

    }

}
