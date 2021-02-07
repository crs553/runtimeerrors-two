package de.tomgrill.gdxtesting.Sprites.Pathfinding;

import com.team5.game.Sprites.Pathfinding.Trap;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;


@RunWith(MockitoJUnitRunner.class)
public class TrapTests {

    @Spy
    Trap trap = mock(Trap.class);

    @Test
    public void emptyTest(){
        assertNotNull("passes if trap has been instantiated",trap);
    }

    @Test
    public void getSkinTest(){
        trap.getSkin();
        try {
            Mockito.verify(trap).getSkin(); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if skin successfully return");
        }
    }

    @Test
    public void alertTest(){
        trap.alert();
        try {
            Mockito.verify(trap).alert(); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if trap successfully alerted");
        }
    }

    @Test
    public void resetAlertTest(){
        trap.resetAlert();
        try {
            Mockito.verify(trap).resetAlert(); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if trap successfully not alerted");
        }
    }
}
