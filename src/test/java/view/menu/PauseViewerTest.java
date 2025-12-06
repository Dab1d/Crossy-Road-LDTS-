package view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.menu.Pause;
import CrossyRoad.view.menu.PauseViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class PauseViewerTest {

    @Test
    public void pauseViewerTest() {
        GUI gui = Mockito.mock(GUI.class);
        Pause pause = new Pause();

        PauseViewer viewer = new PauseViewer(pause);
        viewer.drawElements(gui);

        verify(gui).drawText(new Position(5,5),"Pause", "#FFFFFF");
        verify(gui).drawText(new Position(3,15),"Press Enter", "#FFFFFF");
        verify(gui).drawText(new Position(4,16),"to Select", "#FFFFFF");

        for (int i = 0; i < viewer.getModel().getNumberEntries(); i++){
            verify(gui).drawText(new Position(5,7 + i), viewer.getModel().getEntry(i),
                    viewer.getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
