package CrossyRoad.command;

import CrossyRoad.state.StateManager;
import java.io.IOException;

public class WinCommand implements Command {
    private final StateManager game;

    public WinCommand(StateManager game) {
        this.game = game;
    }

    public void execute() throws IOException {
        game.winGame();
    }
}
