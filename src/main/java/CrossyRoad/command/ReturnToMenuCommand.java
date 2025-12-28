package CrossyRoad.command;

import CrossyRoad.Game;

import java.io.IOException;

public class ReturnToMenuCommand implements Command {
    private final Game game;

    public ReturnToMenuCommand(Game game) {
        this.game = game;
    }

    public void execute() throws IOException {
        game.returnToMenu();
    }
}
