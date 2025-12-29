package view.game;

import CrossyRoad.controller.Game.MoveStrategies.MoveLeftStrategy;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.Truck;
import CrossyRoad.view.game.TruckViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class TruckViewerTest {
    @Test
    void truckViewerDrawsCorrectCharacter() {
        GUI gui = Mockito.mock(GUI.class);
        Truck truck = new Truck(5,5,1,new MoveLeftStrategy());

        TruckViewer viewer = new TruckViewer();
        viewer.draw(truck, gui);

        verify(gui).drawPixel(5, 5,  "#A19E67");
    }
}
