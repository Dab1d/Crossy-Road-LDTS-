package controller.menu;

import CrossyRoad.Controller.Menu.MenuController;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.state.GameState;
import CrossyRoad.state.HelpState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MenuControllerTest {

    private MenuController controller;

    @Mock
    private Menu menuMock;

    @Mock
    private Game gameMock;

    @BeforeEach
    void setUp() {
        controller = new MenuController(menuMock);
    }

    // ---------- MOVIMENTO ----------

    @Test
    void stepLeft_callsPreviousEntry() throws Exception {
        controller.step(gameMock, GUI.ACTION.LEFT, 0);

        verify(menuMock).previousEntry();
        verify(menuMock, never()).nextEntry();
        verify(gameMock, never()).setState(any());
    }

    @Test
    void stepRight_callsNextEntry() throws Exception {
        controller.step(gameMock, GUI.ACTION.RIGHT, 0);

        verify(menuMock).nextEntry();
        verify(menuMock, never()).previousEntry();
        verify(gameMock, never()).setState(any());
    }

    // ---------- SELECT ----------

    @Test
    void stepSelect_whenExitSelected_exitsGame() throws Exception {
        when(menuMock.isSelectedExit()).thenReturn(true);
        when(menuMock.isSelectedStart()).thenReturn(false);
        when(menuMock.isSelectedHelp()).thenReturn(false);

        controller.step(gameMock, GUI.ACTION.SELECT, 0);

        verify(gameMock).setState(null);
    }

    @Test
    void stepSelect_whenStartSelected_startsGame() throws Exception {
        when(menuMock.isSelectedExit()).thenReturn(false);
        when(menuMock.isSelectedStart()).thenReturn(true);
        when(menuMock.isSelectedHelp()).thenReturn(false);
        when(gameMock.getLevel()).thenReturn(1);

        controller.step(gameMock, GUI.ACTION.SELECT, 0);

        verify(gameMock).setState(Mockito.isA(GameState.class));
        verify(gameMock).getLevel();
    }

    @Test
    void stepSelect_whenHelpSelected_goesToHelp() throws Exception {
        when(menuMock.isSelectedExit()).thenReturn(false);
        when(menuMock.isSelectedStart()).thenReturn(false);
        when(menuMock.isSelectedHelp()).thenReturn(true);

        controller.step(gameMock, GUI.ACTION.SELECT, 0);

        verify(gameMock).setState(Mockito.isA(HelpState.class));
    }

    @Test
    void stepSelect_whenNothingSelected_doesNothing() throws Exception {
        when(menuMock.isSelectedExit()).thenReturn(false);
        when(menuMock.isSelectedStart()).thenReturn(false);
        when(menuMock.isSelectedHelp()).thenReturn(false);

        controller.step(gameMock, GUI.ACTION.SELECT, 0);

        verify(gameMock, never()).setState(any());
    }
}

