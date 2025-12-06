package state;

import CrossyRoad.Controller.Menu.WinController;
import CrossyRoad.model.menu.Pause;
import CrossyRoad.model.menu.Win;
import CrossyRoad.state.WinState;
import CrossyRoad.view.menu.WinViewer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinStateTest {
    @Test
    public void testWinState() {
        WinState winState = new WinState(new Win());

        assertTrue(winState.getModel() instanceof Win);
        assertTrue(winState.getViewer() instanceof WinViewer);
        assertTrue(winState.getController() instanceof WinController);
    }
}
