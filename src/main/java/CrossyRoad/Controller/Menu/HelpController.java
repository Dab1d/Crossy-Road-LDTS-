package CrossyRoad.Controller.Menu;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.Help;
import CrossyRoad.state.MenuState;

public class HelpController extends Controller<Help> {

    public HelpController(Help help) {
        super(help);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.QUIT) {
            game.setState(new MenuState(new CrossyRoad.model.menu.Menu()));
        }
    }
}
