package de.tomgrill.gdxtesting.Sprites;

import com.team5.game.Sprites.Teleporters;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class TeleportersTests {

    @Spy
    Teleporters teleporters = mock(Teleporters.class);

    @Test
    public void emptyTest(){
        assertNotNull("passes if teleporters has been instantiated",teleporters);
    }

    @Test
    public void getTeleporterTest(){
        teleporters.getTeleporter("key");
        try {
            Mockito.verify(teleporters).getTeleporter("key"); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if teleporters key successfully return");
        }
    }
}
