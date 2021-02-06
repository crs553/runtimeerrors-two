package de.tomgrill.gdxtesting.Sprites.Pathfinding;

import com.badlogic.gdx.math.Vector2;
import com.team5.game.Sprites.Pathfinding.Link;
import com.team5.game.Sprites.Pathfinding.Node;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(GdxTestRunner.class)
public class LinkTest {

    @Test
    public void emptyTest(){
        Node testFromNode = new Node(0,0,"testFromNode");
        Node testToNode = new Node(0,0,"testToNode");
        Link testLink = new Link(testFromNode, testToNode);
        assertNotNull("passes if link has been instantiated",testLink);
    }

    @Test
    public void getCostTest(){
        int isPass = 0;
        Node testFromNode = new Node(0,0,"testFromNode");
        Node testToNode = new Node(0,0,"testToNode");
        Link testLink = new Link(testFromNode, testToNode);
        if (Vector2.dst(0,0,0,0) == testLink.getCost()){
            isPass = 1;
        }
        assertEquals("passes if link has been instantiated",1,isPass);
    }

    @Test
    public void getFromNodeTest(){
        Node testFromNode = new Node(0,0,"testFromNode");
        Node testToNode = new Node(0,0,"testToNode");
        Link testLink = new Link(testFromNode, testToNode);
        assertEquals("passes if FromNode has been return",testFromNode,testLink.getFromNode());
    }

    @Test
    public void getToNodeTest(){
        Node testFromNode = new Node(0,0,"testFromNode");
        Node testToNode = new Node(0,0,"testToNode");
        Link testLink = new Link(testFromNode, testToNode);
        assertEquals("passes if ToNode has been return",testToNode,testLink.getToNode());
    }
}
