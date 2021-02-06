package de.tomgrill.gdxtesting.Sprites.Pathfinding;

import com.team5.game.Sprites.Pathfinding.Room;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(GdxTestRunner.class)
public class RoomTests {

    @Test
    public void emptyTest(){
        Room testRoom = new Room("test",0,0,"testRoom");
        assertNotNull("passes if Room has been instantiated",testRoom);
    }

    @Test
    public void getXTest(){
        int isPass = 0;
        Room testRoom = new Room("test",1,0,"testRoom");
        if (testRoom.getX() == 16){
            isPass = 1;
        }
        assertEquals("passes if X of Room has been return",1,isPass);
    }

    @Test
    public void getYTest(){
        int isPass = 0;
        Room testRoom = new Room("test",0,1,"testRoom");
        if (testRoom.getY() == 16){
            isPass = 1;
        }
        assertEquals("passes if Y of Room has been return",1,isPass);
    }

    @Test
    public void getNameTest(){
        Room testRoom = new Room("test",0,1,"testRoom");
        assertEquals("passes if Name of Room has been return","testRoom",testRoom.getName());
    }
}
