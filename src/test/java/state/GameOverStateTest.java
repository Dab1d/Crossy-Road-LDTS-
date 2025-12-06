package state;

import CrossyRoad.Controller.Menu.GameOverController;
import CrossyRoad.model.menu.GameOver;
import CrossyRoad.state.GameOverState;
import CrossyRoad.view.Viewer;
import CrossyRoad.view.menu.GameOverView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverStateTest {
    @Test
    public void gameOverStateTest() {
        GameOverState state = new GameOverState(new GameOver());

        assertNotNull(state.getModel());
        assertTrue(state.getModel() instanceof GameOver);

        Viewer<GameOver> viewer = state.getViewer();
        assertNotNull(viewer);
        assertTrue(viewer instanceof GameOverView);

        assertNotNull(state.getController());
        assertTrue(state.getController() instanceof GameOverController);
    }
}
