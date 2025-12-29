package CrossyRoad.command;

import CrossyRoad.state.StateManager;
import java.io.IOException;

public class ReturnToMenuCommand implements Command {
    private final StateManager game;

    public ReturnToMenuCommand(StateManager game) {
        this.game = game;
    }

    public void execute() throws IOException {
        game.returnToMenu();
    }
}
