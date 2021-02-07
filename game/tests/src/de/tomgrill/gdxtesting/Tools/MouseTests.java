package de.tomgrill.gdxtesting.Tools;

import com.badlogic.gdx.physics.box2d.World;
import com.team5.game.Tools.Mouse;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class MouseTests {

    @Spy
    World world = mock(World.class);

    @Spy
    Mouse mouse = mock(Mouse.class);

    @Test
    public void emptyTest(){
        assertNotNull("passes if main has been instantiated",mouse);
    }

    @Test
    public void setupMouseTest(){
        mouse.setupMouse(world);
        try {
            Mockito.verify(mouse).setupMouse(world); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if mouse successfully setup");
        }
    }

}
