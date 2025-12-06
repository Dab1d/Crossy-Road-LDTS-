package CrossyRoad.Controller.Game;

import CrossyRoad.Controler.Game.RiverController;
import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.model.menu.GameOver;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.model.menu.Pause;
import CrossyRoad.state.GameOverState;
import CrossyRoad.state.MenuState;
import CrossyRoad.state.PauseState;

import java.io.IOException;

public class SpaceController extends Controller<Space> {
    private final ChickenController ChickenController;
    private final EndLineController EndLineController;
    private final TruckController TruckController;
    private final CarController CarController;
    private final LogController LogController;
    private final RiverController RiverController;

    public SpaceController(Space space) {
        super(space);
        this.ChickenController = new ChickenController(space);
        this.EndLineController = new EndLineController(space);
        this.TruckController = new TruckController(space);
        this.CarController = new CarController(space);
        this.LogController = new LogController(space);
        this.RiverController = new RiverController(space);
    }

    private boolean chickenDied() {
        return getModel().isChickenDead();
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
            case DOWN:
            case LEFT:
            case RIGHT:
                ChickenController.step(game, action, time);
                EndLineController.step(game, action, time);
                break;
            case PAUSE:
                game.setPrevious(game.getState());
                game.setState(new PauseState(new Pause()));
            default:
                break;
        }
        CarController.step(game, GUI.ACTION.NONE, time);
        TruckController.step(game, GUI.ACTION.NONE, time);
        RiverController.step(game, GUI.ACTION.NONE, time);
        LogController.step(game, GUI.ACTION.NONE, time);

        if (chickenDied()) {
            game.setLevel(1);
            game.setState(new GameOverState(new GameOver()));
        }
        
    }
}



