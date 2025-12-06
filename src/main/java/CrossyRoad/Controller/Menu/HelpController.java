package CrossyRoad.Controller.Menu;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.Help;
import CrossyRoad.state.MenuState;

import java.io.IOException;

public class HelpController extends Controller<Help> {

    public HelpController(Help help) {
        super(help);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT) {
            game.setState(new MenuState());
        }
    }
}
