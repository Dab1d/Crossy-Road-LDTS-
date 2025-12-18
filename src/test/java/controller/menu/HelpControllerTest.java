package controller.menu;


import CrossyRoad.Controller.Menu.HelpController;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.Help;
import CrossyRoad.state.GameState;
import CrossyRoad.state.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HelpControllerTest {

    private HelpController controller;

    @Mock
    private Help helpMock;

    @Mock
    private Game gameMock;

    @BeforeEach
    void setUp() {
        controller = new HelpController(helpMock);
    }

    // ---------- MOVIMENTO ----------

    @Test
    void stepLeft_callsPreviousEntry() throws Exception {
        controller.step(gameMock, GUI.ACTION.LEFT, 0);

        verify(helpMock).previousEntry();
        verify(helpMock, never()).nextEntry();
        verify(gameMock, never()).setState(any());
    }

    @Test
    void stepRight_callsNextEntry() throws Exception {
        controller.step(gameMock, GUI.ACTION.RIGHT, 0);

        verify(helpMock).nextEntry();
        verify(helpMock, never()).previousEntry();
        verify(gameMock, never()).setState(any());
    }

    // ---------- SELECT ----------

    @Test
    void stepSelect_whenStartSelected_startsGame() throws Exception {
        when(helpMock.isSelectedStart()).thenReturn(true);
        when(helpMock.isSelectedReturn()).thenReturn(false);
        when(gameMock.getLevel()).thenReturn(1);

        controller.step(gameMock, GUI.ACTION.SELECT, 0);

        verify(gameMock).setState(Mockito.isA(GameState.class));
        verify(gameMock).getLevel();
    }

    @Test
    void stepSelect_whenReturnSelected_goesToMenu() throws Exception {
        when(helpMock.isSelectedStart()).thenReturn(false);
        when(helpMock.isSelectedReturn()).thenReturn(true);

        controller.step(gameMock, GUI.ACTION.SELECT, 0);

        verify(gameMock).setState(Mockito.isA(MenuState.class));
    }

    @Test
    void stepSelect_whenNothingSelected_doesNothing() throws Exception {
        when(helpMock.isSelectedStart()).thenReturn(false);
        when(helpMock.isSelectedReturn()).thenReturn(false);

        controller.step(gameMock, GUI.ACTION.SELECT, 0);

        verify(gameMock, never()).setState(any());
    }
}

