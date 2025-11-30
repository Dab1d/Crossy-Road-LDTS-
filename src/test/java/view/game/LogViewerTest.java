package view.game;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.Log;
import CrossyRoad.model.game.elements.Log;
import CrossyRoad.view.game.BushViewer;
import CrossyRoad.view.game.LogViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class LogViewerTest {
    @Test
    void logViewerDrawsCorrectCharacter() {
        GUI gui = Mockito.mock(GUI.class);
        Log log = new Log(5,5);

        LogViewer viewer = new LogViewer();
        viewer.draw(log, gui);

        verify(gui).drawCharacter(5, 5, '-', "#905923");
    }
}
