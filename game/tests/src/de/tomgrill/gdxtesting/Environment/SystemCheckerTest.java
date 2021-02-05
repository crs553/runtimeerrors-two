package de.tomgrill.gdxtesting.Environment;

import com.team5.game.Environment.SystemChecker;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;

@RunWith(GdxTestRunner.class)
public class SystemCheckerTest {

    @Test
    public void breakSystemTest(){
        SystemChecker systemTest= new SystemChecker();
        for (int i =0; i < 20; i++){
            systemTest.breakSystem();
        }
        assertTrue("This test returns true if all systems have been broken",
                systemTest.allSystemsBroken());
    }
}
