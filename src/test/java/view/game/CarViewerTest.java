package view.game;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.Car;
import CrossyRoad.model.game.elements.Truck;
import CrossyRoad.view.game.CarViewer;
import CrossyRoad.view.game.TruckViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class CarViewerTest {
    @Test
    void carViewerDrawsCorrectCharacter() {
        GUI gui = Mockito.mock(GUI.class);
        Car car = new Car(5,5);

        CarViewer viewer = new CarViewer();
        viewer.draw(car, gui);

        verify(gui).drawCharacter(5, 5, '+', "#C4A480");
    }
}
