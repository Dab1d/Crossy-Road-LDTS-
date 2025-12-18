package controller.menu;

import CrossyRoad.Controller.Menu.WinController;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.Win;
import CrossyRoad.state.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WinControllerTest {

    private WinController controller;

    @Mock
    private Win winMock;

    @Mock
    private Game gameMock;

    @BeforeEach
    void setUp() {
        controller = new WinController(winMock);
    }

    // ---------- MOVIMENTO ----------

    @Test
    void stepLeft_callsPreviousEntry() throws Exception {
        controller.step(gameMock, GUI.ACTION.LEFT, 0);

        verify(winMock).previousEntry();
        verify(winMock, never()).nextEntry();
        verify(gameMock, never()).setState(any());
    }

    @Test
    void stepRight_callsNextEntry() throws Exception {
        controller.step(gameMock, GUI.ACTION.RIGHT, 0);

        verify(winMock).nextEntry();
        verify(winMock, never()).previousEntry();
        verify(gameMock, never()).setState(any());
    }

    // ---------- SELECT ----------

    @Test
    void stepSelect_whenExitSelected_exitsGame() throws Exception {
        when(winMock.isSelectedExit()).thenReturn(true);
        when(winMock.isSelectedRestart()).thenReturn(false);

        controller.step(gameMock, GUI.ACTION.SELECT, 0);

        verify(gameMock).setState(null);
        verify(gameMock, never()).resetScore();
        verify(gameMock, never()).setLevel(anyInt());
    }

    @Test
    void stepSelect_whenRestartSelected_restartsGame() throws Exception {
        when(winMock.isSelectedExit()).thenReturn(false);
        when(winMock.isSelectedRestart()).thenReturn(true);

        controller.step(gameMock, GUI.ACTION.SELECT, 0);

        verify(gameMock).resetScore();
        verify(gameMock).setLevel(1);
        verify(gameMock).setState(Mockito.isA(GameState.class));
    }

    @Test
    void stepSelect_whenNothingSelected_doesNothing() throws Exception {
        when(winMock.isSelectedExit()).thenReturn(false);
        when(winMock.isSelectedRestart()).thenReturn(false);

        controller.step(gameMock, GUI.ACTION.SELECT, 0);

        verify(gameMock, never()).setState(any());
        verify(gameMock, never()).resetScore();
        verify(gameMock, never()).setLevel(anyInt());
    }
}
