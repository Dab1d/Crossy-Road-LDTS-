package CrossyRoad.Controller.Menu;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.command.Command;
import CrossyRoad.command.QuitCommand;
import CrossyRoad.command.StartCommand;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.menu.Win;
import CrossyRoad.state.GameState;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WinController extends Controller<Win> {
    private Map<Integer, Command> commands;
    public WinController(Win win) {
        super(win);
        commands = new HashMap<>();
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if(commands.isEmpty()){
            commands.put(0, new StartCommand(game));
            commands.put(1, new QuitCommand(game));
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
                if(commands.containsKey(currentOption)){
                    commands.get(currentOption).execute();
                }
        }
    }
}
