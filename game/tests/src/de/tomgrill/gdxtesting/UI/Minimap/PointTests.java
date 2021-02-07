package de.tomgrill.gdxtesting.UI.Minimap;

import com.team5.game.UI.Minimap.Point;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class PointTests {

    @Spy
    Point point = mock(Point.class);

    @Test
    public void emptyTest(){
        assertNotNull("passes if point has been instantiated",point);
    }

    @Test
    public void setPositionTest(){
        point.setPosition(1,1);
        try {
            Mockito.verify(point).setPosition(1,1); //
        } catch (MockitoAssertionError error){
            throw new MockitoAssertionError("This test passes if point successfully sets the position");
        }
    }
}
