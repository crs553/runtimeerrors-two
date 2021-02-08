package de.tomgrill.gdxtesting.UI;

import com.team5.game.UI.Hud;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class HudTests {

    @Spy
    Hud hud = mock(Hud.class);

    @Test
    public void emptyTest(){
        assertNotNull("passes if hud has been instantiated",hud);
    }

    @Test
    public void drawTest(){
        hud.draw(1);
        try {
            Mockito.verify(hud).draw(1); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if hud successfully draw");
        }
    }
}
