package model.game.element;

import CrossyRoad.controller.Game.MoveStrategies.MoveRightStrategy;
import CrossyRoad.model.game.elements.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CarTest {
    Car car;
    @BeforeEach
    public void setUp() {
        this.car = new Car(5,5,1,new MoveRightStrategy());
    }

    @Test
    public void testConstructor() {
        assertEquals(car.getPosition().getX(), 5 );
        assertFalse( car.getPosition().getX() == 6);
        assertFalse( car.getPosition().getX() == 4);


        assertEquals(car.getPosition().getY(), 5);
        assertFalse( car.getPosition().getY() == 6);
        assertFalse( car.getPosition().getY() == 4);
    }
}
