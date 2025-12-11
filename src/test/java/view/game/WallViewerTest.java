package view.game;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.Truck;
import CrossyRoad.model.game.elements.Wall;
import CrossyRoad.view.game.TruckViewer;
import CrossyRoad.view.game.WallViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class WallViewerTest {
    @Test
    void wallViewerDrawsCorrectCharacter() {
        GUI gui = Mockito.mock(GUI.class);
        Wall wall = new Wall(5,5);

        WallViewer viewer = new WallViewer();
        viewer.draw(wall, gui);

        verify(gui).drawCharacter(5, 5, ' ', "#FFFFFF");
    }
}
