package CrossyRoad;

import CrossyRoad.gui.LanternaGUI;
import CrossyRoad.model.game.elements.Bush;
import CrossyRoad.model.game.elements.Log;
import CrossyRoad.model.game.elements.River;
import CrossyRoad.model.game.elements.*;
import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.state.GameState;
import CrossyRoad.state.State;
import CrossyRoad.view.Viewer;
import CrossyRoad.view.game.GameViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(20, 32);
        this.state = new GameState(new LoaderSpaceBuilder(1).createSpace());
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        new Game().start();
    }

    //well be used by the controller to chance between menu and game state
    public void setState(State state) {
        this.state = state;
    }

    public void start() throws IOException {
        while (state != null) {

            state.step(this, gui);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
