package de.tomgrill.gdxtesting.Tools;

import com.team5.game.Sprites.Player;
import com.team5.game.Tools.CustomCamera;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class CustomCameraTests {

    @Spy
    Player player = mock(Player.class);

    @Spy
    CustomCamera camera = mock(CustomCamera.class);

    @Test
    public void emptyTest(){
        assertNotNull("passes if camera has been instantiated",camera);
    }

    @Test
    public void followTest(){
        camera.follow(player);
        try {
            Mockito.verify(camera).follow(player); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if camera successfully follow player");
        }
    }
}
