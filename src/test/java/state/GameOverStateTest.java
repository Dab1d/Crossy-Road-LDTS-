package state;

import CrossyRoad.controller.Menu.GameOverController;
import CrossyRoad.model.menu.GameOver;
import CrossyRoad.state.GameOverState;
import CrossyRoad.view.Viewer;
import CrossyRoad.view.menu.GameOverView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class GameOverStateTest {
    @Test
    public void gameOverStateInitializationTest() {
        GameOver modelMock = mock(GameOver.class);
        GameOverController controllerMock = mock(GameOverController.class);
        GameOverState state = new GameOverState(modelMock, controllerMock);

        assertNotNull(state.getModel());
        assertEquals(modelMock, state.getModel());

        assertNotNull(state.getController());
        assertEquals(controllerMock, state.getController());

        Viewer<GameOver> viewer = state.getViewer();
        assertNotNull(viewer);
        assertTrue(viewer instanceof GameOverView);
    }
}