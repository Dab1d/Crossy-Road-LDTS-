package CrossyRoad;

import CrossyRoad.Controller.GameController;
import CrossyRoad.state.StateManager;
import CrossyRoad.state.StateFactory;
import CrossyRoad.gui.LanternaGUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    public static void main(String[] args) {
        try {
            LanternaGUI gui = new LanternaGUI(20, 32);
            StateManager stateManager = new StateManager(new StateFactory());
            GameController controller = new GameController(stateManager, gui);

            controller.start();

        } catch (IOException | URISyntaxException | FontFormatException e) {
            e.printStackTrace();
        }
    }
}