package state;

import CrossyRoad.Controller.Menu.WinController;
import CrossyRoad.model.loader.Loader;
import CrossyRoad.model.loader.ScreenType;
import CrossyRoad.model.menu.Pause;
import CrossyRoad.model.menu.Win;
import CrossyRoad.state.WinState;
import CrossyRoad.view.menu.WinViewer;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
/**
public class WinStateTest {
    @Test
    public void testWinState() throws IOException {
        Loader loader = new Loader(ScreenType.WIN.getFile());
        Win win = new Win(loader.getLines());
        WinState winState = new WinState();

        assertEquals(win, winState.getModel(), "O modelo no State deve ser o mesmo que foi passado");

        assertInstanceOf(WinViewer.class, winState.getViewer());
        assertInstanceOf(WinController.class, winState.getController());
    }
}
*/