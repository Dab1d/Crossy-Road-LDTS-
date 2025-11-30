package view.game;

import CrossyRoad.gui.GUI;
import CrossyRoad.gui.LanternaGUI;
import CrossyRoad.model.game.elements.Bush;
import CrossyRoad.model.game.elements.Chicken;
import CrossyRoad.view.game.BushViewer;
import CrossyRoad.view.game.ChickenViewer;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class BushViewerTest {
    @Test
    void bushViewerDrawsCorrectCharacter() {
        GUI gui = Mockito.mock(GUI.class);
        Bush bush = new Bush(5,5);

        BushViewer viewer = new BushViewer();
        viewer.draw(bush, gui);

        verify(gui).drawCharacter(5, 5, '█', "#97D077");
    }
}
