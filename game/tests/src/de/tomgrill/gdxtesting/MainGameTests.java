package de.tomgrill.gdxtesting;

import com.team5.game.MainGame;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(GdxTestRunner.class)
public class MainGameTests {

    @Test
    public void createTest(){
        MainGame gameTest = new MainGame();
        assertEquals("This test passes if game have been created",
                gameTest.getLevel(),2);
    }

    @Test
    public void setAndGetLevelTest(){
        MainGame gameTest = new MainGame();
        gameTest.setLevel(3);
        assertEquals("This test passes if game level have been changed",
                gameTest.getLevel(),3);
    }



}
