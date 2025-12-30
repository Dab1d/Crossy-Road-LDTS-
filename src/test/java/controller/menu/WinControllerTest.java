package controller.menu;


import CrossyRoad.controller.Menu.WinController;
import CrossyRoad.state.StateManager;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.Win;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WinControllerTest {
    private WinController controller;
    @Mock private Win model;
    @Mock private StateManager stateManager;

    @BeforeEach
    void setUp() { controller = new WinController(model); }

    @Test
    void stepSelect_Restart() throws Exception {
        when(model.getCurrentEntry()).thenReturn(0);
        controller.step(stateManager, GUI.ACTION.SELECT, 0);
        verify(stateManager).initGame();
    }

    @Test
    void stepSelect_Quit() throws Exception {
        when(model.getCurrentEntry()).thenReturn(1);
        controller.step(stateManager, GUI.ACTION.SELECT, 0);
        verify(stateManager).quitGame();
    }
}