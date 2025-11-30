package model.game.element;

import CrossyRoad.model.game.elements.Bush;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BushTest {
    Bush bush;
    @BeforeEach
    public void setUp() {
        this.bush = new Bush(5,5);
    }

    @Test
    public void testConstructor() {
        assertEquals(bush.getPosition().getX(), 5 );
        assertFalse( bush.getPosition().getX() == 6);
        assertFalse( bush.getPosition().getX() == 4);


        assertEquals(bush.getPosition().getY(), 5);
        assertFalse( bush.getPosition().getY() == 6);
        assertFalse( bush.getPosition().getY() == 4);
    }
}
