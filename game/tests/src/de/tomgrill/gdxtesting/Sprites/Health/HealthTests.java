package de.tomgrill.gdxtesting.Sprites.Health;

import com.team5.game.Sprites.Health.Health;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(GdxTestRunner.class)
public class HealthTests {


    @Test
    public  void  emptyTest(){
        assertNotNull("passes if health has been instantiated", new Health(null, null));
    }

    @Test
    public void setHealthTest(){
        Health health = new Health(null, null);
        health.setHealth(3);
        assertEquals("Health should be 3 to pass",3, health.getHealth());
    }

}
