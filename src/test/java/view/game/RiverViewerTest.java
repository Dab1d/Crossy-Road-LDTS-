package view.game;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.River;
import CrossyRoad.view.game.RiverViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class RiverViewerTest {
    @Test
    void riverViewerDrawsCorrectCharacter() {
        GUI gui = Mockito.mock(GUI.class);
        River river = new River(5,5);

        RiverViewer viewer = new RiverViewer();
        viewer.draw(river, gui);

        verify(gui).drawCharacter(5, 5, '~', "#7EA6E0");
    }
}
