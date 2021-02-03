package de.tomgrill.gdxtesting;

import com.team5.game.MainGame;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(GdxTestRunner.class)
public class MainGameTest {

    @Test
    public void createTest(){
        MainGame gameTest = new MainGame();
        assertEquals("This test passes if game have been created",
                gameTest.getLevel(),2);
    }
}
