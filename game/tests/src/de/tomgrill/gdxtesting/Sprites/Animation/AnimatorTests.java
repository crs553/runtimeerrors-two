package de.tomgrill.gdxtesting.Sprites.Animation;

import com.team5.game.Sprites.Animation.Animator;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(GdxTestRunner.class)
public class AnimatorTests {

    @Test
    public  void emptyTest(){
        int sprite = 0;
        Animator testAnimator = new Animator("idle", "NPC/" + (sprite + 1) + "/Idle");
        assertNotNull("passes if health has been instantiated",testAnimator);
    }

    @Test
    public void isFlippedTest(){
        int sprite = 0;
        Animator testAnimator = new Animator("idle", "NPC/" + (sprite + 1) + "/Idle");
        assertEquals("passes if health has been instantiated",false,testAnimator.isFlipped());
    }

    @Test
    public void finishedTest(){
        int sprite = 0;
        Animator testAnimator = new Animator("idle", "NPC/" + (sprite + 1) + "/Idle");
        assertEquals("passes if health has been instantiated",false,testAnimator.finished());
    }
}
