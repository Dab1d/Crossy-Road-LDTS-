package controller.menu;

import CrossyRoad.Controller.Menu.GameOverController;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.GameOver;
import CrossyRoad.state.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameOverControllerTest {

    private GameOverController controller;

    @Mock
    private GameOver gameOverMock;

    @Mock
    private Game gameMock;

    @BeforeEach
    void setUp() {
        controller = new GameOverController(gameOverMock);
    }

    // ---------- MOVIMENTO ----------

    @Test
    void stepLeft_callsPreviousEntry() throws Exception {
        controller.step(gameMock, GUI.ACTION.LEFT, 0);

        verify(gameOverMock).previousEntry();
        verify(gameOverMock, never()).nextEntry();
        verify(gameMock, never()).setState(any());
    }

    @Test
    void stepRight_callsNextEntry() throws Exception {
        controller.step(gameMock, GUI.ACTION.RIGHT, 0);

        verify(gameOverMock).nextEntry();
        verify(gameOverMock, never()).previousEntry();
        verify(gameMock, never()).setState(any());
    }

    // ---------- SELECT ----------

    @Test
    void stepSelect_whenExitSelected_exitsGame() throws Exception {
        when(gameOverMock.isSelectedExit()).thenReturn(true);
        when(gameOverMock.isSelectedRestart()).thenReturn(false);

        controller.step(gameMock, GUI.ACTION.SELECT, 0);

        verify(gameMock).setState(null);
        verify(gameMock, never()).resetScore();
    }

    @Test
    void stepSelect_whenRestartSelected_restartsGame() throws Exception {
        when(gameOverMock.isSelectedExit()).thenReturn(false);
        when(gameOverMock.isSelectedRestart()).thenReturn(true);
        when(gameMock.getLevel()).thenReturn(1);

        controller.step(gameMock, GUI.ACTION.SELECT, 0);

        verify(gameMock).resetScore();
        verify(gameMock).setState(Mockito.isA(GameState.class));
        verify(gameMock).getLevel();
    }

    @Test
    void stepSelect_whenNothingSelected_doesNothing() throws Exception {
        when(gameOverMock.isSelectedExit()).thenReturn(false);
        when(gameOverMock.isSelectedRestart()).thenReturn(false);

        controller.step(gameMock, GUI.ACTION.SELECT, 0);

        verify(gameMock, never()).setState(any());
        verify(gameMock, never()).resetScore();
    }
}


