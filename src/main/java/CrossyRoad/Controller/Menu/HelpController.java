package CrossyRoad.Controller.Menu;

import CrossyRoad.Controller.Controller;
import CrossyRoad.state.StateManager;
import CrossyRoad.command.Command;
import CrossyRoad.command.ReturnToMenuCommand;
import CrossyRoad.command.StartCommand;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.Help;

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
    public void step(StateManager game, GUI.ACTION action, long time) throws IOException {
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
