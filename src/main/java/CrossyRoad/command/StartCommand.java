package CrossyRoad.command;

import CrossyRoad.Game;
import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.state.GameState;

import java.io.IOException;

public class StartCommand implements Command {
    private final Game game;

    public StartCommand(Game game) {
        this.game = game;
    }

    public void execute() throws IOException {
        game.initGame();
    }
}
