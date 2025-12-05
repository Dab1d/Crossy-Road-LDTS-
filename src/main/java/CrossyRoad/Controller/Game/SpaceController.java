package CrossyRoad.Controller.Game;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.state.GameOverState;
import CrossyRoad.state.MenuState;

import java.io.IOException;

public class SpaceController extends Controller<Space> {
    private final ChickenController ChickenController;
    private final EndLineController EndLineController;
    //private final TruckController TruckController;
    //private final CarController CarController;
    //private final LogController LogController;
    //private final RiverController RiverController;

    public SpaceController(Space space) {
        super(space);
        this.ChickenController = new ChickenController(space);
        this.EndLineController = new EndLineController(space);
        //this.TruckController = new TruckController(space);
        //this.CarController = new CarController(space);
        //this.LogController = new LogController(space);
        //this.RiverController = new RiverController(space);
    }

    private boolean chickenDied() {
        return getModel().isChickenDead();
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        //quit anytime (use this or no?)
        if (action == GUI.ACTION.QUIT) {
            game.setState(new MenuState(new Menu()));
            return;
        }

        switch (action) {
            case UP:
            case DOWN:
            case LEFT:
            case RIGHT:
                ChickenController.step(game, action, time);
                EndLineController.step(game, action, time);
                break;
            default:
                break;
        }

        if (chickenDied()) {
            game.setLevel(1);
            game.setState(new GameOverState());
        }

    }
}



