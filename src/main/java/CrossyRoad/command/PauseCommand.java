package CrossyRoad.command;

import CrossyRoad.state.StateManager;

public class PauseCommand implements Command {
    private final StateManager game;

    public PauseCommand(StateManager game) {
        this.game = game;
    }

    public void execute() {
        game.pauseGame();
    }
}
