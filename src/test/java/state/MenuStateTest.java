package state;

import CrossyRoad.Controller.Menu.MenuController;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.state.MenuState;
import CrossyRoad.view.menu.MenuView;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MenuStateTest {
    @Test
    public void testMenuState() {
        MenuState menuState = new MenuState(new Menu());

        assertNotNull(menuState.getModel());
        assertTrue(menuState.getModel() instanceof Menu);

        assertTrue(menuState.getViewer() instanceof MenuView);

        assertTrue(menuState.getController() instanceof MenuController);

    }
}
