package state;

import CrossyRoad.controller.Game.SpaceController;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.state.GameState;
import CrossyRoad.view.Viewer;
import CrossyRoad.view.game.GameViewer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class GameStateTest {
    @Test
    public void gameStateInitializationTest() {

        Space spaceMock = mock(Space.class);
        SpaceController controllerMock = mock(SpaceController.class);

        GameState state = new GameState(spaceMock, controllerMock);

        assertNotNull(state.getModel());
        assertEquals(spaceMock, state.getModel());

        assertNotNull(state.getController());
        assertEquals(controllerMock, state.getController());

        Viewer<Space> viewer = state.getViewer();
        assertNotNull(viewer);
        assertTrue(viewer instanceof GameViewer);
    }
}