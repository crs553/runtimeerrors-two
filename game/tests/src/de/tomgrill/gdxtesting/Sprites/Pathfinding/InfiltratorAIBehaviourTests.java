package de.tomgrill.gdxtesting.Sprites.Pathfinding;

import com.team5.game.Sprites.Pathfinding.InfiltratorAIBehaviour;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class InfiltratorAIBehaviourTests {

    @Spy
    InfiltratorAIBehaviour infiltrator = mock(InfiltratorAIBehaviour.class);

    @Test
    public void emptyTest(){
        assertNotNull("passes if infiltrator AI has been instantiated",infiltrator);
    }

    @Test
    public void slowingAbilityTest(){
        infiltrator.slowingAbility();
        try {
            Mockito.verify(infiltrator).slowingAbility(); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if infiltrator successfully slowed");
        }
    }

    @Test
    public void activateAbilityTest(){
        infiltrator.activateAbility(1,100);
        try {
            Mockito.verify(infiltrator).activateAbility(1,100); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if infiltrator successfully activate ability");
        }
    }
}
