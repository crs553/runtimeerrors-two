package de.tomgrill.gdxtesting.Environment;

import com.team5.game.Environment.Brig;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(GdxTestRunner.class)
public class BasicBrigTest {

    @Test
    public void initialPrisonerTest(){
        Brig testBrig = new Brig();
        assertFalse("This test passes if the brig is not full upon initialisation",
                testBrig.allCaught());
    }

    @Test
    public void finalPrisonerTest(){
        Brig testBrig = new Brig();
        testBrig.prisoners = 100;
        assertTrue("This test passes if all the infiltrators have beem caught",
                testBrig.allCaught());
    }
}
