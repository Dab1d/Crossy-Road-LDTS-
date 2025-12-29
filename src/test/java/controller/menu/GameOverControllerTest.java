package controller.menu;

import CrossyRoad.controller.Menu.GameOverController;
import CrossyRoad.state.StateManager;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.GameOver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameOverControllerTest {

    private GameOverController controller;

    @Mock
    private GameOver gameOverMock;

    @Mock
    private StateManager gameMock;

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
    void stepSelect_whenRestartSelected_callsStartCommand() throws Exception {
        // No Controller, 0 é o StartCommand (Restart)
        when(gameOverMock.getCurrentEntry()).thenReturn(0);

        controller.step(gameMock, GUI.ACTION.SELECT, 0);

        // O StartCommand deve chamar o método de inicialização do Game
        verify(gameMock).initGame();
        // Garante que NÃO fechou o jogo
        verify(gameMock, never()).quitGame();
    }

    @Test
    void stepSelect_whenExitSelected_callsQuitCommand() throws Exception {
        // No Controller, 1 é o QuitCommand (Exit)
        when(gameOverMock.getCurrentEntry()).thenReturn(1);

        controller.step(gameMock, GUI.ACTION.SELECT, 0);

        // De acordo com o erro que recebeste, o QuitCommand chama quitGame()
        verify(gameMock).quitGame();
        // Garante que NÃO reiniciou o jogo
        verify(gameMock, never()).initGame();
    }

    @Test
    void stepSelect_whenInvalidOption_doesNothing() throws Exception {
        // Se por algum motivo o índice for 99 (não existe no mapa)
        when(gameOverMock.getCurrentEntry()).thenReturn(99);

        controller.step(gameMock, GUI.ACTION.SELECT, 0);

        verify(gameMock, never()).initGame();
        verify(gameMock, never()).setState(any());
    }
}


