import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PositionTest {
    Position position;
    @BeforeEach
    public void setup() {
        this.position = new Position(10,10);
    }

    /** test the getters */
    @Test
    public void testGetX(){
        assertEquals(10,position.getX());
    }

    @Test
    public void testGetY(){
        assertEquals(10,position.getY());
    }

    /** test if the equal objects equal true*/
    @Test
    public void testEqualsObject(){
        assertTrue(position.equals(new Position(10,10)));
    }

    /** test if null objects equal false */
    @Test
    public void testEqualsNullObject(){
        assertFalse(position.equals(null));
    }

    /** test if two position objects have same positions */
    @Test
    public void testEquals(){
        Position p1 = new Position(10,10);
        assertTrue(position.equals(p1));

        Position p2 = new Position(10,8);
        assertFalse(position.equals(p2));
    }


}
