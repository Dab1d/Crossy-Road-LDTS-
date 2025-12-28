package CrossyRoad.command;

import CrossyRoad.Game;

public class HelpCommand implements Command {
    private final Game game;

    public HelpCommand(Game game) {
        this.game = game;
    }

    public void execute() {
        game.goToHelp();
    }
}
