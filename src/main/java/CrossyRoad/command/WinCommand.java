package CrossyRoad.command;

import CrossyRoad.Game;

import java.io.IOException;

public class WinCommand implements Command {
    private final Game game;

    public WinCommand(Game game) {
        this.game = game;
    }

    public void execute() throws IOException {
        game.winGame();
    }
}
