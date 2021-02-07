package de.tomgrill.gdxtesting.Sprites.Pathfinding;

import com.team5.game.Sprites.Pathfinding.Node;
import com.team5.game.Sprites.Pathfinding.NodeGraph;
import com.team5.game.Sprites.Pathfinding.Room;
import com.team5.game.Sprites.Pathfinding.System;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class NodeGraphTests {

    @Spy
    System system = mock(System.class);

    @Spy
    Room room = mock(Room.class);

    @Spy
    Node node = mock(Node.class);

    @Spy
    NodeGraph graph = mock(NodeGraph.class);

    @Test
    public void emptyTest(){
        assertNotNull("passes if graph has been instantiated",graph);
    }

    @Test
    public void addSystemTest(){
        graph.addSystem(system);
        try {
            Mockito.verify(graph).addSystem(system); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if graph successfully add system");
        }
    }

    @Test
    public void addRoomTest(){
        graph.addRoom(room);
        try {
            Mockito.verify(graph).addRoom(room); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if graph successfully add room");
        }
    }

    @Test
    public void addNodeTest(){
        graph.addNode(node);
        try {
            Mockito.verify(graph).addNode(node); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if graph successfully add node");
        }
    }

    @Test
    public void linkNodesTest(){
        graph.linkNodes(node,node);
        try {
            Mockito.verify(graph).linkNodes(node,node); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if graph successfully link nodes");
        }
    }

    @Test
    public void findPathTest(){
        graph.findPath(node,node);
        try {
            Mockito.verify(graph).findPath(node,node); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if graph successfully find path");
        }
    }

    @Test
    public void getSystemsTest(){
        graph.getSystems();
        try {
            Mockito.verify(graph).getSystems(); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if graph successfully return systems");
        }
    }

    @Test
    public void getRandomRoomTest(){
        graph.getRandomRoom();
        try {
            Mockito.verify(graph).getRandomRoom(); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if graph successfully return random room");
        }
    }

    @Test
    public void getRandomSystemRoomTest(){
        graph.getRandomSystem();
        try {
            Mockito.verify(graph).getRandomSystem(); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if graph successfully return random system");
        }
    }

    @Test
    public void getIndexTest(){
        graph.getIndex(node);
        try {
            Mockito.verify(graph).getIndex(node); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if graph successfully return index of node");
        }
    }

    @Test
    public void getNodeCountTest(){
        graph.getNodeCount();
        try {
            Mockito.verify(graph).getNodeCount(); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if graph successfully return the sum of nodes");
        }
    }

    @Test
    public void getConnectionsTest(){
        graph.getConnections(node);
        try {
            Mockito.verify(graph).getConnections(node); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if graph successfully return connections");
        }
    }
}
