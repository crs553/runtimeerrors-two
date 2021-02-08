package de.tomgrill.gdxtesting.UI.Minimap;

import com.team5.game.UI.Minimap.Minimap;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class MinimapTests {

    @Spy
    Minimap minimap = mock(Minimap.class);

    @Test
    public void emptyTest(){
        assertNotNull("passes if minimap has been instantiated",minimap);
    }

    @Test
    public void drawTest(){
        minimap.draw(1);
        try {
            Mockito.verify(minimap).draw(1); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if minimap successfully draw");
        }
    }

    @Test
    public void disposeTest(){
        minimap.dispose();
        try {
            Mockito.verify(minimap).dispose(); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if minimap successfully dispose");
        }
    }
}
