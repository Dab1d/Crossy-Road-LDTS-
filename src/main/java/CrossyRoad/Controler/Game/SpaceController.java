package CrossyRoad.Controler.Game;

import CrossyRoad.Controler.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.state.MenuState;

import java.io.IOException;

public class SpaceController extends Controller<Space> {
    private final ChickenController ChickenController;
//    private final MonsterController monsterController;

    public SpaceController(Space space) {
        super(space);
        this.ChickenController = new ChickenController(space);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT) game.setState(new MenuState(new Menu()));
        switch (action) {
            case UP:
            case DOWN:
            case LEFT:
            case RIGHT:
                ChickenController.step(game, action, time);
                break;

            case QUIT:
                game.setState(new MenuState(new Menu()));
                break;

            default:
                break;
        }
    }
}
