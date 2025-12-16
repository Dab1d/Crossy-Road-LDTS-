package CrossyRoad.Controller.Menu;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.loader.Loader;
import CrossyRoad.model.menu.Help;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.state.GameState;
import CrossyRoad.state.HelpState;
import CrossyRoad.state.MenuState;

import java.io.IOException;

public class HelpController extends Controller<Help> {

    public HelpController(Help help) {
        super(help);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case LEFT:
                getModel().previousEntry();
                break;
            case RIGHT:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedStart()) game.setState(new GameState(new LoaderSpaceBuilder(game.getLevel()).createSpace()));
                if (getModel().isSelectedReturn()) game.setState(new MenuState(new Menu(new Loader("loadscreen").getLines())));
        }
    }
}
