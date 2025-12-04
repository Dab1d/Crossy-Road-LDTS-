package CrossyRoad;

import CrossyRoad.gui.LanternaGUI;
import CrossyRoad.model.game.elements.*;
import CrossyRoad.state.MenuState;
import CrossyRoad.state.State;
import CrossyRoad.model.menu.Menu;


import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(20, 32);
        this.state = new MenuState(new Menu());
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        new Game().start();
    }

    //will be used by the controller to chance between menu and game state
    public void setState(State state) {
        this.state = state;
    }

    public void start() throws IOException {
        int FPS = 80;
        int frameTime = 1000 / FPS;
        while (state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;
            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gui.close();
    }

}
