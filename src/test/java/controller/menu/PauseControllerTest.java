package controller.menu;


import CrossyRoad.controller.Menu.PauseController;
import CrossyRoad.state.StateManager;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.Pause;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PauseControllerTest {
    private PauseController controller;
    @Mock private Pause model;
    @Mock private StateManager stateManager;

    @BeforeEach
    void setUp() { controller = new PauseController(model); }

    @Test
    void stepSelect_Resume() throws Exception {
        when(model.getCurrentEntry()).thenReturn(0);
        controller.step(stateManager, GUI.ACTION.SELECT, 0);
        verify(stateManager).resumeGame();
    }

    @Test
    void stepSelect_ReturnToMenu() throws Exception {
        when(model.getCurrentEntry()).thenReturn(1);
        controller.step(stateManager, GUI.ACTION.SELECT, 0);
        verify(stateManager).returnToMenu();
    }

    @Test
    void stepSelect_Quit() throws Exception {
        when(model.getCurrentEntry()).thenReturn(2);
        controller.step(stateManager, GUI.ACTION.SELECT, 0);
        verify(stateManager).quitGame();
    }
}