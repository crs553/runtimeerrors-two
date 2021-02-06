package de.tomgrill.gdxtesting.Sprites.Animation;

import com.team5.game.Sprites.Animation.AnimatedDrawable;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;

@RunWith(GdxTestRunner.class)
public class AnimatedDrawableTests {

    @Test
    public void emptyTest(){
        int sprite = 0;
        AnimatedDrawable testAnimatorDrawable = new AnimatedDrawable("idle", "Teleporter/Idle", 1f);
        assertNotNull("passes if AnimatedDrawable has been instantiated",testAnimatorDrawable);
    }
    
}
