package CrossyRoad.Controller.Menu;

import CrossyRoad.Controller.Controller;
import CrossyRoad.state.StateManager;
import CrossyRoad.command.Command;
import CrossyRoad.command.QuitCommand;
import CrossyRoad.command.ResumeCommand;
import CrossyRoad.command.ReturnToMenuCommand;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.Pause;

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
    public void step(StateManager game, GUI.ACTION action, long time) throws IOException {
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
