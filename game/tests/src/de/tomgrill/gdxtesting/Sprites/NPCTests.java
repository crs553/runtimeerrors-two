package de.tomgrill.gdxtesting.Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.team5.game.MainGame;
import com.team5.game.Screens.PlayScreen;
import com.team5.game.Sprites.NPC;
import com.team5.game.Sprites.Pathfinding.Node;
import com.team5.game.Sprites.Pathfinding.NodeGraph;
import net.bytebuddy.implementation.Implementation;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.badlogic.gdx.Gdx;

import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;


@RunWith(GdxTestRunner.class)
public class NPCTests {


    MainGame game = new MainGame();
    Vector2 direction = new Vector2(10,10);
    PlayScreen screen = new PlayScreen(game,false);

    NodeGraph graph = new NodeGraph();

    Node node = new Node(1,1,"test");

    World world =new World(direction,false);

    NPC testNPC = new NPC(screen,world, graph, node, direction);


//    @Before
//    public void init(){
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    public void createTest(){
        assertNotNull(testNPC);

    }
}
