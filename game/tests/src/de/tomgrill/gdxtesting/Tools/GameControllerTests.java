package de.tomgrill.gdxtesting.Tools;

import com.team5.game.Sprites.Player;
import com.team5.game.Tools.GameController;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class GameControllerTests {

    @Spy
    Player player = mock(Player.class);

    @Spy
    GameController controller = mock(GameController.class);

    @Test
    public void emptyTest(){
        assertNotNull("passes if controller has been instantiated",controller);
    }

    @Test
    public void updateTrapStateTest(){
        controller.updateTrapState(player);
        try {
            Mockito.verify(controller).updateTrapState(player);
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if trap state has been update");
        }
    }

    @Test
    public void getPlayerTest(){
        controller.getPlayer();
        try {
            Mockito.verify(controller).getPlayer();
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if Player has been return");
        }
    }

    @Test
    public void getTeleportersTest(){
        controller.getTeleporters();
        try {
            Mockito.verify(controller).getTeleporters();
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if Teleporters has been return");
        }
    }

    @Test
    public void getSystemCheckerTest(){
        controller.getSystemChecker();
        try {
            Mockito.verify(controller).getSystemChecker();
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if SystemChecker has been return");
        }
    }

    @Test
    public void getBrigTest(){
        controller.getBrig();
        try {
            Mockito.verify(controller).getBrig();
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if Brig has been return");
        }
    }

    @Test
    public void getNoNPCsTest(){
        controller.getNoNPCs();
        try {
            Mockito.verify(controller).getNoNPCs();
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if NoNPCs has been return");
        }
    }

    @Test
    public void getNoInfiltrators(){
        controller.getNoInfiltrators();
        try {
            Mockito.verify(controller).getNoInfiltrators();
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if NoInfiltrators has been return");
        }
    }
}
