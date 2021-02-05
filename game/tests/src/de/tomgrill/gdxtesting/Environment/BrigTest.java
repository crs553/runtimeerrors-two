package de.tomgrill.gdxtesting.Environment;

import com.team5.game.Environment.Brig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BrigTest {

    @InjectMocks
    Brig testBrig;

    @Test
    public void initialPrisonerTest(){
        assertFalse("This test passes if the brig is not full upon initialisation",
                testBrig.allCaught());
    }

    @Test
    public void finalPrisonerTest(){
        for (int i = 0; i<15; i++){
            testBrig.imprison();
        }
        assertTrue("This test passes if all the infiltrators have been caught",
                testBrig.allCaught());
    }

    @Test
    public void getPrisonerTest(){
        assertEquals(testBrig.getPrisoners(),0);
    }
    @Test
    public void getPrisonerAfterCaptureTest(){
        testBrig.imprison();
        assertEquals(testBrig.getPrisoners(),1);
    }
}
