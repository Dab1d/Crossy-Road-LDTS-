package CrossyRoad.Controller.Menu;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.loader.Loader;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.model.menu.Pause;
import CrossyRoad.state.GameState;
import CrossyRoad.state.HelpState;
import CrossyRoad.state.MenuState;

import java.io.IOException;

public class PauseController extends Controller<Pause> {
    public PauseController(Pause pause) {
        super(pause);
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedQuit()) game.setState(null);
                if (getModel().isSelectedMenu()){
                    game.setLevel(1);
                    game.setState(new MenuState(new Menu(new Loader("loadscreen").getLines())));
                }
                if (getModel().isSelectedResume()) game.setState(game.getPrevious());
        }
    }
}
