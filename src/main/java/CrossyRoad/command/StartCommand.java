package CrossyRoad.command;

import CrossyRoad.state.StateManager;

import java.io.IOException;

public class StartCommand implements Command {
    private final StateManager game;

    public StartCommand(StateManager game) {
        this.game = game;
    }

    public void execute() throws IOException {
        game.initGame();
    }
}
