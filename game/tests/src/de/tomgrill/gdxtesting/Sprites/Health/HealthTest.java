package de.tomgrill.gdxtesting.Sprites.Health;

import com.team5.game.Sprites.Health.Health;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class HealthTest {

    @Spy
    Health health = mock(Health.class,"health");

    @Test
    public  void  emptyTest(){
        assertNotNull("passes if health has been instantiated",health);
    }

    @Test
    public void setHealthTest(){
        health.setHealth(3);
        assertEquals("passes if health has been set",3,health.getHealth());
    }
}
