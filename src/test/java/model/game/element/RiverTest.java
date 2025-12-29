package model.game.element;

import CrossyRoad.controller.Game.MoveStrategies.MoveRightStrategy;
import CrossyRoad.model.game.elements.River;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RiverTest {
    River river;
    @BeforeEach
    public void setUp() {
        this.river = new River(5,5, 1, new MoveRightStrategy());
    }

    @Test
    public void testConstructor() {
        assertEquals(river.getPosition().getX(), 5 );
        assertFalse( river.getPosition().getX() == 6);
        assertFalse( river.getPosition().getX() == 4);


        assertEquals(river.getPosition().getY(), 5);
        assertFalse( river.getPosition().getY() == 6);
        assertFalse( river.getPosition().getY() == 4);
    }
}
