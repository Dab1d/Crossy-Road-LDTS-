package CrossyRoad.command;

import CrossyRoad.state.StateManager;
import java.io.IOException;

public class LoseCommand implements Command {
    private final StateManager game;

    public LoseCommand(StateManager game) {
        this.game = game;
    }

    public void execute() throws IOException {
        game.loseGame();
    }
}
