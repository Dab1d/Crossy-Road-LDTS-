package model.game.element;

import CrossyRoad.model.game.elements.Chicken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ChickenTest {
    Chicken chicken;
    @BeforeEach
    public void setUp() {
        this.chicken = new Chicken(5,5);
    }

    @Test
    public void testConstructor() {
        assertEquals(chicken.getPosition().getX(), 5 );
        assertFalse( chicken.getPosition().getX() == 6);
        assertFalse( chicken.getPosition().getX() == 4);

        assertEquals(chicken.getPosition().getY(), 5);
        assertFalse( chicken.getPosition().getY() == 6);
        assertFalse( chicken.getPosition().getY() == 4);
    }
}
