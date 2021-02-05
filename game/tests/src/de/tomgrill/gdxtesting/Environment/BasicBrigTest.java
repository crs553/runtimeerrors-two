package de.tomgrill.gdxtesting.Environment;

import com.team5.game.Environment.Brig;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BasicBrigTest {

    @InjectMocks
    Brig testBrig;

    @Test
    public void initialPrisonerTest(){
        assertFalse("This test passes if the brig is not full upon initialisation",
                testBrig.allCaught());
    }

    @Test
    public void finalPrisonerTest(){
        for (int i = 0; i<8; i++){
            testBrig.imprison();
        }
        assertTrue("This test passes if all the infiltrators have been caught",
                testBrig.allCaught());
    }

    @Test
    public void getPrisonerTest(){

    }
}
