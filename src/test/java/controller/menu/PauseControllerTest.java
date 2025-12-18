package controller.menu;

import CrossyRoad.state.State;
import CrossyRoad.Controller.Menu.PauseController;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.Pause;
import CrossyRoad.state.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PauseControllerTest {

    private PauseController controller;

    @Mock
    private Pause pauseMock;

    @Mock
    private Game gameMock;

    @BeforeEach
    void setUp() {
        controller = new PauseController(pauseMock);
    }

    // ---------- MOVIMENTO ----------

    @Test
    void stepUp_callsPreviousEntry() throws Exception {
        controller.step(gameMock, GUI.ACTION.UP, 0);

        verify(pauseMock).previousEntry();
        verify(pauseMock, never()).nextEntry();
        verify(gameMock, never()).setState(any());
    }

    @Test
    void stepDown_callsNextEntry() throws Exception {
        controller.step(gameMock, GUI.ACTION.DOWN, 0);

        verify(pauseMock).nextEntry();
        verify(pauseMock, never()).previousEntry();
        verify(gameMock, never()).setState(any());
    }

    // ---------- SELECT ----------

    @Test
    void stepSelect_whenQuitSelected_exitsGame() throws Exception {
        when(pauseMock.isSelectedQuit()).thenReturn(true);
        when(pauseMock.isSelectedMenu()).thenReturn(false);
        when(pauseMock.isSelectedResume()).thenReturn(false);

        controller.step(gameMock, GUI.ACTION.SELECT, 0);

        verify(gameMock).setState(null);
        verify(gameMock, never()).setLevel(anyInt());
    }

    @Test
    void stepSelect_whenMenuSelected_goesToMenu() throws Exception {
        when(pauseMock.isSelectedQuit()).thenReturn(false);
        when(pauseMock.isSelectedMenu()).thenReturn(true);
        when(pauseMock.isSelectedResume()).thenReturn(false);

        controller.step(gameMock, GUI.ACTION.SELECT, 0);

        verify(gameMock).setLevel(1);
        verify(gameMock).setState(Mockito.isA(MenuState.class));
    }

    @Test
    void stepSelect_whenResumeSelected_returnsToPreviousState() throws Exception {
        when(pauseMock.isSelectedQuit()).thenReturn(false);
        when(pauseMock.isSelectedMenu()).thenReturn(false);
        when(pauseMock.isSelectedResume()).thenReturn(true);

        State previousStateMock = mock(State.class);
        when(gameMock.getPrevious()).thenReturn(previousStateMock);


        controller.step(gameMock, GUI.ACTION.SELECT, 0);

        verify(gameMock).setState(previousStateMock);
    }

    @Test
    void stepSelect_whenNothingSelected_doesNothing() throws Exception {
        when(pauseMock.isSelectedQuit()).thenReturn(false);
        when(pauseMock.isSelectedMenu()).thenReturn(false);
        when(pauseMock.isSelectedResume()).thenReturn(false);

        controller.step(gameMock, GUI.ACTION.SELECT, 0);

        verify(gameMock, never()).setState(any());
        verify(gameMock, never()).setLevel(anyInt());
    }
}
