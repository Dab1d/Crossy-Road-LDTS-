package CrossyRoad.Controller.Menu;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.command.Command;
import CrossyRoad.command.HelpCommand;
import CrossyRoad.command.QuitCommand;
import CrossyRoad.command.StartCommand;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.menu.Help;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.state.GameState;
import CrossyRoad.state.HelpState;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MenuController extends Controller<Menu> {
    private Map<Integer, Command> commands;

    public MenuController(Menu menu, Game game) {
        super(menu);

        commands = new HashMap<>();
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (commands.isEmpty()) {
            commands.put(0, new StartCommand(game));
            commands.put(1, new HelpCommand(game));
            commands.put(2, new QuitCommand(game));
        }

        switch (action) {
            case LEFT:
                getModel().previousEntry();
                break;
            case RIGHT:
                getModel().nextEntry();
                break;
            case SELECT:
                int currentOption = getModel().getCurrentEntry();
                if(commands.containsKey(currentOption)) {
                    commands.get(currentOption).execute();
                }
        }
    }
}
