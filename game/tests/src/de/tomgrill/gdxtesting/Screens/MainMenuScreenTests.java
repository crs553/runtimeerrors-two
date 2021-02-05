package de.tomgrill.gdxtesting.Screens;

import com.team5.game.MainGame;
import com.team5.game.Screens.MainMenuScreen;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class MainMenuScreenTests {

    @Spy
    MainGame game = mock(MainGame.class);

    @Spy
    MainMenuScreen main = mock(MainMenuScreen.class, "mock");

    @Test
    public void emptyTest(){
        assertNotNull(main);
    }

    @Test
    public void openTest(){
        game.setScreen(main);
        Mockito.verify(game).setScreen(main);
    }

    public void setupTests(){

    }


}
