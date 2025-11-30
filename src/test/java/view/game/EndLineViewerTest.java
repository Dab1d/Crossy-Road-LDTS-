package view.game;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.EndLine;
import CrossyRoad.model.game.elements.Wall;
import CrossyRoad.view.game.EndLineViewer;
import CrossyRoad.view.game.WallViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class EndLineViewerTest {
    @Test
    void endLineViewerDrawsCorrectCharacter() {
        GUI gui = Mockito.mock(GUI.class);
        EndLine endLine = new EndLine(5,5);

        EndLineViewer viewer = new EndLineViewer();
        viewer.draw(endLine, gui);

        verify(gui).drawCharacter(5, 5, '=', "#F00000");
    }
}
