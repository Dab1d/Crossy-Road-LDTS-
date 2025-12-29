package state;

import CrossyRoad.controller.Menu.MenuController;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.state.MenuState;
import CrossyRoad.view.menu.MenuView;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class MenuStateTest {
    @Test
    public void testMenuState() throws IOException {
        MenuState menuState = new MenuState();

        assertNotNull(menuState.getModel());
        assertTrue(menuState.getModel() instanceof Menu);

        assertTrue(menuState.getViewer() instanceof MenuView);

        assertTrue(menuState.getController() instanceof MenuController);

    }
}
