package CrossyRoad.Controller.Menu;

import CrossyRoad.Controller.Controller;
import CrossyRoad.state.StateManager;
import CrossyRoad.command.Command;
import CrossyRoad.command.QuitCommand;
import CrossyRoad.command.StartCommand;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.GameOver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GameOverController extends Controller<GameOver> {
    private Map<Integer, Command> commands;
    public GameOverController(GameOver gameover) {
        super(gameover);

        commands = new HashMap<>();
    }

    @Override
    public void step(StateManager game, GUI.ACTION action, long time) throws IOException {
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
