package controller.menu;

import CrossyRoad.controller.Menu.HelpController;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.Help;
import CrossyRoad.state.StateManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HelpControllerTest {
    private HelpController controller;
    @Mock private Help model;
    @Mock
    private StateManager stateManager;

    @BeforeEach
    void setUp() { controller = new HelpController(model); }

    @Test
    void stepSelect_StartGameFromHelp() throws Exception {
        when(model.getCurrentEntry()).thenReturn(0);
        controller.step(stateManager, GUI.ACTION.SELECT, 0);
        verify(stateManager).initGame();
    }

    @Test
    void stepSelect_ReturnToMenu() throws Exception {
        when(model.getCurrentEntry()).thenReturn(1);
        controller.step(stateManager, GUI.ACTION.SELECT, 0);
        verify(stateManager).returnToMenu();
    }
}