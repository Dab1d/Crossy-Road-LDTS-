package CrossyRoad.Controller.Menu;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.menu.Win;
import CrossyRoad.state.GameState;
import java.io.IOException;

public class WinController extends Controller<Win> {
    public WinController(Win win) {
        super(win);
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
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedRestart()){
                    game.setLevel(1);
                    game.setState(new GameState(new LoaderSpaceBuilder(1).createSpace()));
                }
        }
    }
}
