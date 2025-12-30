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
    private GameOver modelMock;

    @Mock
    private StateManager stateManagerMock;

    @BeforeEach
    void setUp() {
        controller = new GameOverController(modelMock);
    }

    @Test
    void stepSelect_whenRestartSelected_callsInitGame() throws Exception {
        // Configuramos o model para dizer que estamos na opção 0 (Restart)
        when(modelMock.getCurrentEntry()).thenReturn(0);

        // Chamamos o step apenas com o stateManager e a ação
        controller.step(stateManagerMock, GUI.ACTION.SELECT, 0);

        // Verifica se o comando chamou initGame no manager
        verify(stateManagerMock).initGame();
        verify(stateManagerMock, never()).quitGame();
    }

    @Test
    void stepSelect_whenExitSelected_callsQuitGame() throws Exception {
        // Opção 1 (Quit)
        when(modelMock.getCurrentEntry()).thenReturn(1);

        controller.step(stateManagerMock, GUI.ACTION.SELECT, 0);

        // Verifica se chamou quitGame
        verify(stateManagerMock).quitGame();
        verify(stateManagerMock, never()).initGame();
    }
}