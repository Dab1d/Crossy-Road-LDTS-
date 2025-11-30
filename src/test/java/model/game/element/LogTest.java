package model.game.element;

import CrossyRoad.model.game.elements.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LogTest {
    Log log;
    @BeforeEach
    public void setUp() {
        this.log = new Log(5,5);
    }

    @Test
    public void testConstructor() {
        assertEquals(log.getPosition().getX(), 5 );
        assertFalse( log.getPosition().getX() == 6);
        assertFalse( log.getPosition().getX() == 4);


        assertEquals(log.getPosition().getY(), 5);
        assertFalse( log.getPosition().getY() == 6);
        assertFalse( log.getPosition().getY() == 4);
    }
}
