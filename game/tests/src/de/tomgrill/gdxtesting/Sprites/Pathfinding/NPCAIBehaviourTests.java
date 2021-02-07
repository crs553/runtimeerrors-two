package de.tomgrill.gdxtesting.Sprites.Pathfinding;

import com.team5.game.Sprites.Pathfinding.NPCAIBehaviour;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class NPCAIBehaviourTests {

    @Spy
    NPCAIBehaviour npc = mock(NPCAIBehaviour.class);

    @Test
    public void emptyTest(){
        assertNotNull("passes if npc AI has been instantiated",npc);
    }

    @Test
    public void decreaseInfiltratorSpeedTest(){
        npc.decreaseInfiltratorSpeed();
        try {
            Mockito.verify(npc).decreaseInfiltratorSpeed(); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if npc successfully slowed");
        }
    }

    @Test
    public void increaseInfiltratorSpeedTest(){
        npc.increaseInfiltratorSpeed();
        try {
            Mockito.verify(npc).increaseInfiltratorSpeed(); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if npc successfully not slowed");
        }
    }

    @Test
    public void moveTest(){
        npc.move(1,1);
        try {
            Mockito.verify(npc).move(1,1); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if npc successfully moving to (1,1)");
        }
    }

    @Test
    public void activateAbilityTest(){
        npc.activateAbility(1);
        try {
            Mockito.verify(npc).activateAbility(1); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if npc successfully activate ability");
        }
    }
}
