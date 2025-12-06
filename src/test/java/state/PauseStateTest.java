package state;

import CrossyRoad.Controller.Menu.PauseController;
import CrossyRoad.model.menu.Pause;
import CrossyRoad.state.PauseState;
import CrossyRoad.view.menu.PauseViewer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PauseStateTest {
    @Test
    public void testPauseState() {
        PauseState pauseState = new PauseState(new Pause());

        assertTrue(pauseState.getModel() instanceof Pause);

        assertTrue(pauseState.getViewer() instanceof PauseViewer);

        assertTrue(pauseState.getController() instanceof PauseController);

    }
}
