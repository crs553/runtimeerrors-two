package de.tomgrill.gdxtesting.Sprites.Health;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;
import com.team5.game.MainGame;
import com.team5.game.Sprites.Health.Health;
<<<<<<< Updated upstream
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
=======
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
>>>>>>> Stashed changes

@RunWith(GdxTestRunner.class)
public class HealthTest {
    @Spy
    MainGame main = mock(MainGame.class);
    @Spy
    Player player = mock(Player.class);

<<<<<<< Updated upstream
    @Spy
    Health health = mock(Health.class, "health");

    @Test
    public  void  emptyTest(){
        assertNotNull("passes if health has been instantiated",health);
    }

=======
>>>>>>> Stashed changes
    @Test
    public void setHealthTest(){
        Health health = new Health(null, null);
        health.setHealth(3);
<<<<<<< Updated upstream
        Mockito.when(health.getHealth()).thenReturn(3);
        assertEquals("Health should be 3 to pass",3, health.getHealth());
=======
        assertEquals("passes if health has been set",3, health.getHealth());
>>>>>>> Stashed changes
    }

}
