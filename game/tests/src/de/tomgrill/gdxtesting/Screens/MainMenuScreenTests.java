package de.tomgrill.gdxtesting.Screens;

import com.team5.game.Screens.MainMenuScreen;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class MainMenuScreenTests {

    MainMenuScreen main = mock(MainMenuScreen.class, "mock");

    @Test
    public void loadTest(){
        assertTrue(main instanceof MainMenuScreen);
    }
}
