package view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.view.menu.MenuView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class MenuViewerTest {
    @Test
    public void menuViewerTest() {
        GUI gui = Mockito.mock(GUI.class);
        Menu menu = new Menu();

        MenuView viewer = new MenuView(menu);
        viewer.drawElements(gui);

        verify(gui).drawText(new Position(8, 1), "Menu", "#FFFFFF");

        int num = menu.getNumberEntries();
        for (int i = 0; i < num; i++) {
            verify(gui).drawText(new Position(2 + i * 6, 4),
                    viewer.getModel().getEntry(i),
                    viewer.getModel().isSelected(i) ? "#FFBA66" : "#2E89A6");
        }

    }
}
