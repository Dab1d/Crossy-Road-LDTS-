package view.menu;

import CrossyRoad.gui.GUI;

import CrossyRoad.model.Position;
import CrossyRoad.model.menu.Help;
import CrossyRoad.view.menu.HelpView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class HelpViewerTest {
    @Test
    public void helpViewerTest() {
        GUI gui = Mockito.mock(GUI.class);
        Help help = new Help();

        HelpView viewer = new HelpView(help);

        viewer.drawElements(gui);

        int y = 0;
        for (String line : viewer.getModel().getLines()) {
            verify(gui).drawText(new Position(0, y), line, (y == 0) ? "#FFF888" : "#FFFFFF");
            y++;
        }
    }
}
