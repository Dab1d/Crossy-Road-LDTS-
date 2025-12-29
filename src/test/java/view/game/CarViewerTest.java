package view.game;

import CrossyRoad.controller.Game.MoveStrategies.MoveRightStrategy;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.Car;
import CrossyRoad.view.game.CarViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class CarViewerTest {
    @Test
    void carViewerDrawsCorrectCharacter() {
        GUI gui = Mockito.mock(GUI.class);
        Car car = new Car(5,5,1,new MoveRightStrategy());

        CarViewer viewer = new CarViewer();
        viewer.draw(car, gui);

        verify(gui).drawPixel(5, 5,  "#540D00");
    }
}
