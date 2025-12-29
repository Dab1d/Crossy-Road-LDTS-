package CrossyRoad.Controller;

import CrossyRoad.state.StateManager;
import CrossyRoad.state.GameState;
import CrossyRoad.gui.GUI;
import CrossyRoad.view.menu.HUDView;

import java.io.IOException;

public class GameController {
    private final StateManager game;
    private final GUI gui;
    private final HUDView hud;

    public GameController(StateManager game, GUI gui) {
        this.game = game;
        this.gui = gui;
        this.hud = new HUDView();
    }

    public void start() throws IOException {
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while (game.getState() != null) {
            long startTime = System.currentTimeMillis();

            game.getState().step(game, gui, startTime);
            if (game.getState() instanceof GameState)  hud.draw(gui, game.getScore(), game.getLevel());

            gui.refresh();

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