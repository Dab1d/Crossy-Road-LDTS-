package CrossyRoad.command;

import CrossyRoad.Game;

public class ResumeCommand implements Command {
    private final Game game;

    public ResumeCommand(Game game) {
        this.game = game;
    }

    public void execute() {
        game.resumeGame();
    }
}
