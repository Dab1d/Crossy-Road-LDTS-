package model.game.element;

import CrossyRoad.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class WallTest {
    Wall wall;
    @BeforeEach
    public void setUp() {
        this.wall = new Wall(5,5);
    }

    @Test
    public void testConstructor() {
        assertEquals(wall.getPosition().getX(), 5 );
        assertFalse( wall.getPosition().getX() == 6);
        assertFalse( wall.getPosition().getX() == 4);


        assertEquals(wall.getPosition().getY(), 5);
        assertFalse( wall.getPosition().getY() == 6);
        assertFalse( wall.getPosition().getY() == 4);
    }
}
