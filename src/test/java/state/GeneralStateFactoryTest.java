package state;

import CrossyRoad.controller.Game.SpaceController;
import CrossyRoad.controller.Menu.*;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.model.menu.*;
import CrossyRoad.state.*;
import CrossyRoad.view.GameViewer;
import CrossyRoad.view.menu.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GeneralStateFactoryTest {

    private GeneralStateFactory factory;

    @BeforeEach
    void setUp() {
        factory = new GeneralStateFactory();
    }

    @Test
    void testCreateMenuState() throws IOException {
        State state = factory.createMenuState();

        assertNotNull(state, "O estado não deve ser nulo");
        assertInstanceOf(MenuState.class, state, "A factory deve retornar uma instância de MenuState");

        assertInstanceOf(Menu.class, state.getModel());
        assertInstanceOf(MenuController.class, state.getController());
        assertInstanceOf(MenuView.class, state.getViewer());
    }

    @Test
    void testCreateGameState() throws IOException {
        int level = 1;
        State state = factory.createGameState(level);

        assertNotNull(state);
        assertInstanceOf(GameState.class, state);

        assertInstanceOf(Space.class, state.getModel());
        assertInstanceOf(SpaceController.class, state.getController());
        assertInstanceOf(GameViewer.class, state.getViewer());
    }

    @Test
    void testCreatePauseState() {
        State state = factory.createPauseState();

        assertNotNull(state);
        assertInstanceOf(PauseState.class, state);

        assertInstanceOf(Pause.class, state.getModel());
        assertInstanceOf(PauseController.class, state.getController());
        assertInstanceOf(PauseViewer.class, state.getViewer());
    }

    @Test
    void testCreateWinState() throws IOException {
        State state = factory.createWinState();

        assertNotNull(state);
        assertInstanceOf(WinState.class, state);

        assertInstanceOf(Win.class, state.getModel());
        assertInstanceOf(WinController.class, state.getController());
        assertInstanceOf(WinViewer.class, state.getViewer());
    }

    @Test
    void testCreateGameOverState() throws IOException {
        State state = factory.createGameOverState();

        assertNotNull(state);
        assertInstanceOf(GameOverState.class, state);

        assertInstanceOf(GameOver.class, state.getModel());
        assertInstanceOf(GameOverController.class, state.getController());
        assertInstanceOf(GameOverView.class, state.getViewer());
    }

    @Test
    void testCreateHelpState() throws IOException {
        State state = factory.createHelpState();

        assertNotNull(state);
        assertInstanceOf(HelpState.class, state);

        assertInstanceOf(Help.class, state.getModel());
        assertInstanceOf(HelpController.class, state.getController());
        assertInstanceOf(HelpView.class, state.getViewer());
    }
}