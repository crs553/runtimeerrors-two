package de.tomgrill.gdxtesting.Sprites;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.team5.game.MainGame;
import com.team5.game.Screens.PlayScreen;
import com.team5.game.Sprites.NPC;
import com.team5.game.Sprites.Pathfinding.Node;
import com.team5.game.Sprites.Pathfinding.NodeGraph;
import com.team5.game.Sprites.Player;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.graalvm.compiler.graph.Graph;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(GdxTestRunner.class)
public class NPCTests {

//    @Mock
//    private World world;
//
//    @Mock
//    private PlayScreen screen ;
//
//    @Mock
//    private NodeGraph graph ;
//
//    @Mock
//    private Node node ;
//
//    @Mock
//    private Vector2 vec ;
//
//    NPC testNPC;
//
////    @Before
////    public void setUp(){
////        testNPC = new NPC()
////    }
//
//
    @Test
    public void emptyTest(){
        NPC npcTest = new NPC(mock(PlayScreen.class),mock(World.class),mock(NodeGraph.class),mock(Node.class),mock(Vector2.class));
        assertNotNull("Passes if the NPC is not null", npcTest);
    }
}
