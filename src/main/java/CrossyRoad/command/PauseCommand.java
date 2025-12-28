package CrossyRoad.command;

import CrossyRoad.Game;

public class PauseCommand implements Command {
    private final Game game;

    public PauseCommand(Game game) {
        this.game = game;
    }

    public void execute() {
        game.pauseGame();
    }
}
