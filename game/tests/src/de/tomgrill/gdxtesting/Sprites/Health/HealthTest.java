package de.tomgrill.gdxtesting.Sprites.Health;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;
import com.team5.game.MainGame;
import com.team5.game.Sprites.Health.Health;
import com.team5.game.Sprites.Player;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.*;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.junit.MockitoJUnitRunner;
import sun.rmi.rmic.Main;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(GdxTestRunner.class)
public class HealthTest {
    @Spy
    MainGame main = mock(MainGame.class);
    @Spy
    Player player = mock(Player.class);

    @Spy
    Health health = mock(Health.class, "health");

    @Test
    public  void  emptyTest(){
        assertNotNull("passes if health has been instantiated",health);
    }

    @Test
    public void setHealthTest(){
        health.setHealth(3);
        Mockito.when(health.getHealth()).thenReturn(3);
        assertEquals("Health should be 3 to pass",3, health.getHealth());
    }
}
