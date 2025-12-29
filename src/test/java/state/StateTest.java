package state;

import CrossyRoad.Controller.Controller;
import CrossyRoad.state.StateManager;
import CrossyRoad.gui.GUI;
import CrossyRoad.state.State;
import CrossyRoad.view.Viewer;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;


public class StateTest {

    // ---- FakeState DEFINIDA DENTRO DO TESTE ----
    private static class FakeState extends State<Object> {
        private final Viewer<Object> viewer;
        private final Controller<Object> controller;

        public FakeState(Viewer<Object> viewer, Controller<Object> controller) {
            super(new Object());
            this.viewer = viewer;
            this.controller = controller;
        }

        @Override
        public Viewer<Object> getViewer() {
            return viewer;
        }

        @Override
        public Controller<Object> getController() {
            return controller;
        }
    }

    @Test
    void testStepWithMocks() throws IOException {
        GUI gui = mock(GUI.class);
        StateManager game = mock(StateManager.class);

        Viewer<Object> viewer = mock(Viewer.class);
        Controller<Object> controller = mock(Controller.class);

        when(gui.getNextAction()).thenReturn(GUI.ACTION.UP);

        State<Object> state = new State<>(new Object(), viewer, controller) {
            @Override
            public Viewer<Object> getViewer() {
                return viewer;
            }

            @Override
            public Controller<Object> getController() {
                return controller;
            }
        };

        state.step(game, gui, 123L);

        verify(gui).getNextAction();
        verify(controller).step(game, GUI.ACTION.UP, 123L);
        verify(viewer).draw(gui);
    }
}
