package de.tomgrill.gdxtesting.Sprites.Pathfinding;

import com.team5.game.Sprites.Pathfinding.Node;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(GdxTestRunner.class)
public class NodeTests {

    @Test
    public void emptyTest(){
        Node testNode = new Node(0,0,"testNode");
        assertNotNull("passes if Node has been instantiated",testNode);
    }

    @Test
    public void getXTest(){
        int isPass = 0;
        Node testNode = new Node(1,0,"testNode");
        if (testNode.getX() == 16){
            isPass = 1;
        }
        assertEquals("passes if X of Node has been return",1,isPass);
    }

    @Test
    public void getYTest(){
        int isPass = 0;
        Node testNode = new Node(0,1,"testNode");
        if (testNode.getY() == 16){
            isPass = 1;
        }
        assertEquals("passes if Y of Node has been return",1,isPass);
    }

    @Test
    public void getNameTest(){
        Node testNode = new Node(0,0,"testNode");
        assertEquals("passes if Name of Node has been return","testNode",testNode.getName());
    }
}
