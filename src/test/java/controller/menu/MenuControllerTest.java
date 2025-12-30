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
    @Mock private Menu model;
    @Mock private StateManager stateManager;

    @BeforeEach
    void setUp() { controller = new MenuController(model); }

    @Test
    void stepSelect_Start() throws Exception {
        when(model.getCurrentEntry()).thenReturn(0);
        controller.step(stateManager, GUI.ACTION.SELECT, 0);
        verify(stateManager).initGame();
    }

    @Test
    void stepSelect_Help() throws Exception {
        when(model.getCurrentEntry()).thenReturn(1);
        controller.step(stateManager, GUI.ACTION.SELECT, 0);
        verify(stateManager).goToHelp();
    }

    @Test
    void stepSelect_Quit() throws Exception {
        when(model.getCurrentEntry()).thenReturn(2);
        controller.step(stateManager, GUI.ACTION.SELECT, 0);
        verify(stateManager).quitGame();
    }
}