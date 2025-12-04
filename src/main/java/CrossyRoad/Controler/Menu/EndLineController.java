package CrossyRoad.Controler.Menu;

import CrossyRoad.Controler.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.EndLine;
import CrossyRoad.state.MenuState;

public class EndLineController extends Controller<EndLine> {

    public EndLineController(EndLine endLine) {
        super(endLine);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.QUIT) {
            game.setState(new MenuState(new CrossyRoad.model.menu.Menu()));
        }
    }
}
