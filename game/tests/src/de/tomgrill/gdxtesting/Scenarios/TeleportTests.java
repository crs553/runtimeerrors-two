package de.tomgrill.gdxtesting.Scenarios;

import com.team5.game.MainGame;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class TeleportTests {

    @Spy
    MainGame game = mock(MainGame.class, "game");

    @Test
    public void emptyTest() { assertNotNull("passes if game has been instantiated", game); }
}
