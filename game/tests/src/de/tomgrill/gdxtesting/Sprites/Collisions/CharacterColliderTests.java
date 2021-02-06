package de.tomgrill.gdxtesting.Sprites.Collisions;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.team5.game.Sprites.Collisions.CharacterCollider;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class CharacterColliderTests {
    @Test
    public void defineColliderCheck(){
        CharacterCollider charCollider = new CharacterCollider();
        World world = new World(new Vector2(1920,1080),true);
        Vector2 position = new Vector2(50*16,95*16);
        Body b2bBody = charCollider.defineCollider(world,position,16);

        assertTrue(b2bBody.isSleepingAllowed() && b2bBody.getPosition().equals(position));

    }
}
