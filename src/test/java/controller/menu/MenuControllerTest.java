package controller.menu;

import CrossyRoad.controller.Menu.MenuController;
import CrossyRoad.state.StateManager;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MenuControllerTest {

    private MenuController controller;

    @Mock
    private Menu menuMock;

    @Mock
    private StateManager gameMock;

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
    void stepSelect_Start() throws Exception {
        when(menuMock.getCurrentEntry()).thenReturn(0);
        controller.step(gameMock, GUI.ACTION.SELECT, 0);
        verify(gameMock).initGame();
    }

    @Test
    void stepSelect_Help() throws Exception {
        when(menuMock.getCurrentEntry()).thenReturn(1);
        controller.step(gameMock, GUI.ACTION.SELECT, 0);
        verify(gameMock).goToHelp(); // Assume que o HelpCommand chama goToHelp
    }

    @Test
    void stepSelect_Quit() throws Exception {
        when(menuMock.getCurrentEntry()).thenReturn(2);
        controller.step(gameMock, GUI.ACTION.SELECT, 0);
        verify(gameMock).quitGame();
    }

    @Test
    void stepSelect_whenInvalidOption_doesNothing() throws Exception {
        when(menuMock.getCurrentEntry()).thenReturn(99);

        controller.step(gameMock, GUI.ACTION.SELECT, 0);

        verify(gameMock, never()).initGame();
        verify(gameMock, never()).goToHelp();
        verify(gameMock, never()).quitGame();
        verify(gameMock, never()).setState(any());
    }
}

