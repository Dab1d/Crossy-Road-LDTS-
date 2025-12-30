package state;

import CrossyRoad.session.GameSession;
import CrossyRoad.state.State;
import CrossyRoad.state.StateFactory;
import CrossyRoad.state.StateManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StateManagerTest {

    @Mock
    private StateFactory stateFactory;
    @Mock
    private State menuState;
    @Mock
    private State gameState;
    @Mock
    private State pauseState;
    @Mock
    private State winState;
    @Mock
    private State gameOverState;
    @Mock
    private State helpState;
    @Mock
    private GameSession gameSession;

    private StateManager stateManager;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        when(stateFactory.createMenuState()).thenReturn(menuState);
        stateManager = new StateManager(stateFactory, gameSession);    }

    @Test
    void testConstructorInitialization() {
        assertEquals(menuState, stateManager.getState());
        assertNotNull(stateManager.getGameSession());
    }

    @Test
    void testPauseGame() throws IOException {
        when(stateFactory.createPauseState()).thenReturn(pauseState);
        State estadoAntesDaPausa = stateManager.getState();
        stateManager.pauseGame();

        assertEquals(estadoAntesDaPausa, stateManager.getPrevious());
        assertEquals(pauseState, stateManager.getState());
    }

    @Test
    void testResumeGameWithPreviousState() {
        stateManager.setPrevious(menuState);
        stateManager.setState(pauseState);
        stateManager.resumeGame();

        assertEquals(menuState, stateManager.getState());
    }

    @Test
    void testResumeGameWithoutPreviousState() {
        stateManager.setPrevious(null);
        stateManager.setState(menuState);
        stateManager.resumeGame();

        assertEquals(menuState, stateManager.getState());
    }

    @Test
    void testWinGame() throws IOException {
        when(stateFactory.createWinState()).thenReturn(winState);
        stateManager.winGame();

        assertEquals(winState, stateManager.getState());
    }

    @Test
    void testLoseGame() throws IOException {
        when(stateFactory.createGameOverState()).thenReturn(gameOverState);
        stateManager.loseGame();

        assertEquals(gameOverState, stateManager.getState());
    }

    @Test
    void testGoToHelp() throws IOException {
        when(stateFactory.createHelpState()).thenReturn(helpState);
        stateManager.goToHelp();

        assertEquals(helpState, stateManager.getState());
    }

    @Test
    void testQuitGame() {
        stateManager.quitGame();
        assertNull(stateManager.getState());
    }

    @Test
    void testAdvanceLevelNotMax() throws IOException {
        when(stateFactory.createGameState(anyInt())).thenReturn(gameState);
        when(gameSession.isMaxLevel()).thenReturn(false);
        when(gameSession.getLevel()).thenReturn(5);

        stateManager.advanceLevel();

        verify(gameSession).nextLevel();
        verify(stateFactory).createGameState(5);
        assertEquals(gameState, stateManager.getState());
    }

    @Test
    void testFinishGame() throws IOException {
        when(stateFactory.createWinState()).thenReturn(winState);
        stateManager.finishGame();

        verify(stateFactory).createWinState();
        assertEquals(winState, stateManager.getState());
    }

    @Test
    void testAdvanceLevelAtMaxLevel() throws IOException, URISyntaxException, FontFormatException {
        when(stateFactory.createMenuState()).thenReturn(menuState);
        when(stateFactory.createWinState()).thenReturn(winState);
        GameSession sessionMock = mock(GameSession.class);
        when(sessionMock.isMaxLevel()).thenReturn(true);

        StateManager manager = new StateManager(stateFactory, sessionMock);
        manager.advanceLevel();

        verify(sessionMock).isMaxLevel();
        verify(sessionMock, never()).nextLevel();
        verify(stateFactory).createWinState();
        assertEquals(winState, manager.getState());
    }
    @Test
    void testInitGame() throws IOException {
        when(stateFactory.createGameState(anyInt())).thenReturn(gameState);
        when(gameSession.getLevel()).thenReturn(1);

        stateManager.initGame();

        verify(gameSession).resetScore();
        verify(gameSession).resetLevel();
        verify(stateFactory).createGameState(1);
        assertEquals(gameState, stateManager.getState());
    }

    @Test
    void testReturnToMenu() throws IOException {
        stateManager.setState(pauseState);
        stateManager.returnToMenu();

        verify(gameSession).resetLevel();
        verify(gameSession).resetScore();


        assertEquals(menuState, stateManager.getState());
    }
    @Test
    void testConvenienceConstructorCreatesRealSession() throws IOException, URISyntaxException, FontFormatException {
        when(stateFactory.createMenuState()).thenReturn(menuState);
        StateManager localManager = new StateManager(stateFactory);

        assertNotNull(localManager.getGameSession(), "O construtor deve criar uma GameSession interna");
        assertNotEquals(gameSession, localManager.getGameSession(), "A sessão interna deve ser uma nova instância, não o mock injetado no setUp");
        assertEquals(0, localManager.getGameSession().getScore());
        assertEquals(1, localManager.getGameSession().getLevel());
        assertEquals(menuState, localManager.getState());
    }

}