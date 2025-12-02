package CrossyRoad.Controler.Menu;

import CrossyRoad.Controler.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.state.GameState;
import CrossyRoad.state.HelpState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
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
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) game.setState(new GameState(new LoaderSpaceBuilder(1).createSpace()));
                if (getModel().isSelectedHelp()) game.setState(new HelpState());
        }
    }
}
