package view;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.model.menu.Win;
import CrossyRoad.view.Viewer;
import CrossyRoad.view.menu.MenuView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.verify;

public class ViewerTest {
    @Test
    public void testViewer() throws IOException {
        GUI gui = Mockito.mock(GUI.class);
        Menu menu = Mockito.mock(Menu.class);

        MenuView viewer = new MenuView(menu);

        viewer.draw(gui);

        verify(gui).clear();
        verify(gui).refresh();
    }
}
