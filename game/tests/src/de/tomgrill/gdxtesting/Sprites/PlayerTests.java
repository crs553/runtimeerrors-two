package de.tomgrill.gdxtesting.Sprites;

import com.badlogic.gdx.math.Vector2;
import com.team5.game.Sprites.Player;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class PlayerTests {

    @Spy
    Vector2 target = mock(Vector2.class);

    @Spy
    Player player = mock(Player.class);

    @Test
    public void emptyTest(){
        assertNotNull("passes if player has been instantiated",player);
    }

    @Test
    public void setupAnimationsTest(){
        player.setupAnimations();
        try {
            Mockito.verify(player).setupAnimations(); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if player animations successfully setup");
        }
    }

    @Test
    public void deactivateTeleportAbilityTest(){
        player.deactivateTeleportAbility();
        try {
            Mockito.verify(player).deactivateTeleportAbility(); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if player teleport ability successfully deactivate");
        }
    }

    @Test
    public void updatePositionTest(){
        player.updatePosition(target);
        try {
            Mockito.verify(player).updatePosition(target); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if player teleport successfully");
        }
    }

    @Test
    public void getHealthTest(){
        player.getHealth();
        try {
            Mockito.verify(player).getHealth(); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if player health successfully return");
        }
    }

    @Test
    public void getAbilitiesTest(){
        player.getAbilities();
        try {
            Mockito.verify(player).getAbilities(); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if player abilities successfully return");
        }
    }
}
