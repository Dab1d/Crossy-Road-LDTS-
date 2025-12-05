package CrossyRoad.Controller.Menu;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.GameOver;
import CrossyRoad.state.MenuState;

public class GameOverController extends Controller<GameOver> {
    public GameOverController(GameOver gameover) {
        super(gameover);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.QUIT) {
            game.setLevel(1);
            game.setState(new MenuState(new CrossyRoad.model.menu.Menu()));
        }
    }
}
