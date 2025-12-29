package CrossyRoad.command;

import CrossyRoad.state.StateManager;

import java.io.IOException;

public class HelpCommand implements Command {
    private final StateManager game;

    public HelpCommand(StateManager game) {
        this.game = game;
    }

    public void execute() throws IOException {
        game.goToHelp();
    }
}
