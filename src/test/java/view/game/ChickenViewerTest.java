package view.game;

import CrossyRoad.gui.GUI;
import CrossyRoad.gui.LanternaGUI;
import CrossyRoad.model.game.elements.Chicken;
import CrossyRoad.view.game.ChickenViewer;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class ChickenViewerTest {
    @Test
    void chickenViewerDrawsCorrectCharacter() {
        GUI gui = Mockito.mock(GUI.class);
        Chicken chicken = new Chicken(5,5);

        ChickenViewer viewer = new ChickenViewer();
        viewer.draw(chicken, gui);

        verify(gui).drawCharacter(5, 5, 'G', "#FF00FF");
    }
}
