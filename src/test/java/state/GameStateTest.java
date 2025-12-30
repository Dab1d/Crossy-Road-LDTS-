package state;

import CrossyRoad.controller.Controller;
import CrossyRoad.controller.Game.SpaceController;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.session.GameSession;
import CrossyRoad.state.GameState;
import CrossyRoad.state.StateManager;
import CrossyRoad.view.Viewer;
import CrossyRoad.view.GameViewer;
import CrossyRoad.view.menu.HUDView;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameStateTest {
    @Test
    public void gameStateInitializationTest() {
        Space spaceMock = mock(Space.class);
        GameViewer viewerMock = mock(GameViewer.class);
        SpaceController controllerMock = mock(SpaceController.class);

        GameState state = new GameState(spaceMock, controllerMock, viewerMock);

        assertNotNull(state.getModel());
        assertSame(spaceMock, state.getModel());
        assertNotNull(state.getController());
        assertSame(controllerMock, state.getController());
        Viewer<Space> viewer = state.getViewer();
        assertNotNull(viewer);
        assertSame(viewerMock, viewer, "O viewer retornado deve ser a mesma instância injetada");
    }
    @Test
    void testStep_CallsAllComponents() throws IOException {
        Space space = mock(Space.class);
        Controller<Space> controller = mock(Controller.class);
        Viewer<Space> viewer = mock(Viewer.class);
        StateManager stateManager = mock(StateManager.class);
        GUI gui = mock(GUI.class);
        GameSession session = mock(GameSession.class);

        HUDView hudMock = mock(HUDView.class);

        when(gui.getNextAction()).thenReturn(GUI.ACTION.UP);
        when(stateManager.getGameSession()).thenReturn(session);
        when(session.getScore()).thenReturn(100);
        when(session.getLevel()).thenReturn(5);

        GameState gameState = new GameState(space, controller, viewer, hudMock);

        gameState.step(stateManager, gui, 1234L);

        verify(controller).step(stateManager, GUI.ACTION.UP, 1234L);
        verify(viewer).draw(gui);
        verify(hudMock).draw(gui, 100, 5);
    }
}