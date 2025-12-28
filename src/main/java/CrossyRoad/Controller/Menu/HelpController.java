package CrossyRoad.Controller.Menu;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.command.Command;
import CrossyRoad.command.ReturnToMenuCommand;
import CrossyRoad.command.StartCommand;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.loader.Loader;
import CrossyRoad.model.menu.Help;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.state.GameState;
import CrossyRoad.state.HelpState;
import CrossyRoad.state.MenuState;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HelpController extends Controller<Help> {
    private Map<Integer, Command> commands;

    public HelpController(Help help) {
        super(help);

        commands = new HashMap<>();
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if(commands.isEmpty()){
            commands.put(0, new StartCommand(game));
            commands.put(1, new ReturnToMenuCommand(game));
        }
        switch (action) {
            case LEFT:
                getModel().previousEntry();
                break;
            case RIGHT:
                getModel().nextEntry();
                break;
            case SELECT:
                int currentOpiton = getModel().getCurrentEntry();
                if(commands.containsKey(currentOpiton)){
                    commands.get(currentOpiton).execute();
                }
        }
    }
}
