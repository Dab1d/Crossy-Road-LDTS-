package controller.game;

import CrossyRoad.Controller.Game.CarController;
import CrossyRoad.Controller.Game.MoveStrategies.MoveRightStrategy;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.game.elements.Car;
import CrossyRoad.model.game.space.Space;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class CarControllerTest {

    @Test
    void carsDoNotMoveBefore400ms() {
        // Arrange
        Space space = new Space(10, 10);
        Car car = new Car(2,2,1,new MoveRightStrategy());
        space.setCars(List.of(car));

        CarController controller = new CarController(space);
        Game gameMock = mock(Game.class);

        // Act
        controller.step(gameMock, GUI.ACTION.NONE, 0);

        // Assert
        assertEquals(2, car.getPosition().getX());
    }

    @Test
    void carsMoveRightAfter400ms() {
        // Arrange
        Space space = new Space(10, 10);
        Car car = new Car(2,5,1,new MoveRightStrategy());
        space.setCars(List.of(car));

        CarController controller = new CarController(space);
        Game gameMock = mock(Game.class);

        // Act
        controller.step(gameMock, GUI.ACTION.NONE, 400);

        // Assert
        assertEquals(3, car.getPosition().getX());
    }

    @Test
    void carWrapsAroundWhenExceedingWidth() {
        // Arrange
        Space space = new Space(10, 10);
        Car car = new Car(9,5,1,new MoveRightStrategy());
        space.setCars(List.of(car));

        CarController controller = new CarController(space);
        Game gameMock = mock(Game.class);

        // Act
        controller.step(gameMock, GUI.ACTION.NONE, 400);

        // Assert
        assertEquals(0, car.getPosition().getX());
    }
}
