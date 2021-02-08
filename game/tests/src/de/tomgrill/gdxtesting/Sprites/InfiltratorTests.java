package de.tomgrill.gdxtesting.Sprites;

import com.team5.game.Sprites.Infiltrator;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class InfiltratorTests {

    @Spy
    Infiltrator infiltrator = mock(Infiltrator.class);

    @Test
    public void emptyTest(){
        assertNotNull("passes if infiltrator has been instantiated",infiltrator);
    }

    @Test
    public void changeSkinTest(){
        infiltrator.changeSkin();
        try {
            Mockito.verify(infiltrator).changeSkin(); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if infiltrator successfully change skin");
        }
    }

    @Test
    public void beenCaughtTest(){
        infiltrator.beenCaught();
        try {
            Mockito.verify(infiltrator).beenCaught(); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if infiltrator successfully been caught");
        }
    }

    @Test
    public void disposeTest(){
        infiltrator.dispose();
        try {
            Mockito.verify(infiltrator).dispose(); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if infiltrator successfully disposed");
        }
    }
}
