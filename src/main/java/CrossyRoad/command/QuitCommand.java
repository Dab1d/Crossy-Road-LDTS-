package CrossyRoad.command;

import CrossyRoad.state.StateManager;

public class QuitCommand implements Command {
    private final StateManager game;
    public QuitCommand(StateManager game) {
        this.game = game;
    }

    public void execute() {
        game.quitGame();
    }
}
