package CrossyRoad.Controller.Menu;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.command.Command;
import CrossyRoad.command.QuitCommand;
import CrossyRoad.command.ResumeCommand;
import CrossyRoad.command.ReturnToMenuCommand;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.loader.Loader;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.model.menu.Pause;
import CrossyRoad.state.GameState;
import CrossyRoad.state.HelpState;
import CrossyRoad.state.MenuState;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PauseController extends Controller<Pause> {
    private Map<Integer, Command> commands;
    public PauseController(Pause pause) {
        super(pause);

        commands = new HashMap<>();
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if(commands.isEmpty()){
            commands.put(0, new ResumeCommand(game));
            commands.put(1, new ReturnToMenuCommand(game));
            commands.put(2, new QuitCommand(game));
        }
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
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
