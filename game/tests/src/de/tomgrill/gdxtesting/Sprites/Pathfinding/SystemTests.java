package de.tomgrill.gdxtesting.Sprites.Pathfinding;

import com.team5.game.Sprites.Pathfinding.System;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(GdxTestRunner.class)
public class SystemTests {

    @Test
    public void emptyTest(){
        System testSystem = new System("test",0,0,"testSystem",0,0);
        assertNotNull("passes if System has been instantiated",testSystem);
    }

    @Test
    public void getXTest(){
        int isPass = 0;
        System testSystem = new System("test",1,0,"testSystem",0,0);
        if (testSystem.getX() == 16){
            isPass = 1;
        }
        assertEquals("passes if X of System has been return",1,isPass);
    }

    @Test
    public void getYTest(){
        int isPass = 0;
        System testSystem = new System("test",0,1,"testSystem",0,0);
        if (testSystem.getY() == 16){
            isPass = 1;
        }
        assertEquals("passes if Y of System has been return",1,isPass);
    }

    @Test
    public void getNameTest(){
        System testSystem = new System("test",0,1,"testSystem",0,0);
        assertEquals("passes if Name of System has been return","testSystem",testSystem.getName());
    }

    @Test
    public void destoryTest(){
        System testSystem = new System("test",0,1,"testSystem",0,0);
        testSystem.destroy();
        assertEquals("passes if System has been destroy",true,testSystem.getBroken());
    }
}
