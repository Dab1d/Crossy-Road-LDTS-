package CrossyRoad.command;

import CrossyRoad.state.StateManager;

public class ResumeCommand implements Command {
    private final StateManager game;

    public ResumeCommand(StateManager game) {
        this.game = game;
    }

    public void execute() {
        game.resumeGame();
    }
}
