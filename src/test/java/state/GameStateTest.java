package state;

import CrossyRoad.Controller.Game.SpaceController;
import CrossyRoad.Controller.Menu.GameOverController;
import CrossyRoad.model.game.elements.Chicken;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.model.menu.GameOver;
import CrossyRoad.state.GameOverState;
import CrossyRoad.state.GameState;
import CrossyRoad.state.State;
import CrossyRoad.view.Viewer;
import CrossyRoad.view.game.GameViewer;
import CrossyRoad.view.menu.GameOverView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class GameStateTest {
    @Test
    public void gameStateStateTest() {
        Space space = new Space(20, 20);
        space.setChicken(new Chicken(5, 5));
        space.setTrucks(new ArrayList<>());
        space.setCars(new ArrayList<>());
        space.setLogs(new ArrayList<>());
        space.setRiver(new ArrayList<>());
        space.setWalls(new ArrayList<>());
        space.setBushes(new ArrayList<>());
        space.setEndLines(new ArrayList<>());

        GameState state = new GameState(space);

        assertNotNull(state.getModel());
        assertTrue(state.getModel() instanceof Space);

        Viewer<Space> viewer = state.getViewer();
        assertNotNull(viewer);
        assertTrue(viewer instanceof GameViewer);

        assertNotNull(state.getController());
        assertTrue(state.getController() instanceof SpaceController);
    }
}
