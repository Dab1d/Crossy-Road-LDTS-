package state;

import CrossyRoad.controller.Controller;
import CrossyRoad.controller.Menu.PauseController;
import CrossyRoad.model.menu.Pause;
import CrossyRoad.state.PauseState;
import CrossyRoad.view.menu.PauseViewer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class PauseStateTest {
    @Test
    public void testPauseStateInitialization() {
        Pause model = new Pause();
       Controller<Pause> controller = mock(PauseController.class);
        PauseState pauseState = new PauseState(model, controller);

        assertSame(model, pauseState.getModel(), "O modelo retornado deve ser a mesma instância passada no construtor");
        assertSame(controller, pauseState.getController(), "O controller retornado deve ser a mesma instância passada no construtor");
        assertTrue(pauseState.getViewer() instanceof PauseViewer, "O viewer deve ser uma instância de PauseViewer");
    }
}