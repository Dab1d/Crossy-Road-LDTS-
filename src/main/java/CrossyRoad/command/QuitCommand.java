package CrossyRoad.command;

import CrossyRoad.Game;
import CrossyRoad.gui.GUI;

import java.io.IOException;

public class QuitCommand implements Command {
    private final Game game;
    public QuitCommand(Game game) {
        this.game = game;
    }

    public void execute() {
        game.quitGame();
    }
}
