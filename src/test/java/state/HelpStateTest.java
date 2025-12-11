package state;

import CrossyRoad.Controller.Menu.HelpController;
import CrossyRoad.model.menu.Help;
import CrossyRoad.model.menu.Pause;
import CrossyRoad.state.HelpState;
import CrossyRoad.view.menu.HelpView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelpStateTest {
    @Test
    public void testHelpState() {
        HelpState helpState = new HelpState(new Help());

        assertTrue(helpState.getModel() instanceof Help);
        assertTrue(helpState.getViewer() instanceof HelpView);
        assertTrue(helpState.getController() instanceof HelpController);
    }
}
