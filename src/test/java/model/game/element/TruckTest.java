package model.game.element;

import CrossyRoad.Controller.Game.MoveStrategies.MoveLeftStrategy;
import CrossyRoad.model.game.elements.Truck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TruckTest {
    Truck truck;
    @BeforeEach
    public void setUp() {
        this.truck = new Truck(5,5,1, new MoveLeftStrategy());
    }

    @Test
    public void testConstructor() {
        assertEquals(truck.getPosition().getX(), 5 );
        assertFalse( truck.getPosition().getX() == 6);
        assertFalse( truck.getPosition().getX() == 4);


        assertEquals(truck.getPosition().getY(), 5);
        assertFalse( truck.getPosition().getY() == 6);
        assertFalse( truck.getPosition().getY() == 4);
    }
}
