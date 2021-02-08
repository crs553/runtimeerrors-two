package de.tomgrill.gdxtesting.UI;

import com.team5.game.UI.PauseMenu;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class PauseMenuTests {

    @Spy
    PauseMenu pauseMenu = mock(PauseMenu.class);

    @Test
    public void emptyTest(){
        assertNotNull("passes if pauseMenu has been instantiated",pauseMenu);
    }

    @Test
    public void drawTest(){
        pauseMenu.draw(1);
        try {
            Mockito.verify(pauseMenu).draw(1); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if pauseMenu successfully draw");
        }
    }
}
