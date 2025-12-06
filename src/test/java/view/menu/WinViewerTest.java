package view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.menu.Win;
import CrossyRoad.view.menu.WinViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class WinViewerTest {
    @Test
    public void testWinViewer() {
        GUI gui = Mockito.mock(GUI.class);
        Win win = new Win();

        WinViewer viewer = new WinViewer(win);
        viewer.drawElements(gui);

        verify(gui).drawText(new Position(5,5),"YOU WON", "#FFFFFF");

        for (int i = 0; i < viewer.getModel().getNumberEntries(); i++){
            verify(gui).drawText(new Position(5,7 + i),
                    viewer.getModel().getEntry(i),
                    viewer.getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
