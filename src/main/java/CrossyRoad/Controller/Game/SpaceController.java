package CrossyRoad.Controller.Game;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.model.loader.Loader;
import CrossyRoad.model.menu.GameOver;
import CrossyRoad.model.menu.Pause;
import CrossyRoad.state.GameOverState;
import CrossyRoad.state.PauseState;

import java.io.IOException;
import java.util.List;

public class SpaceController extends Controller<Space> {

    // Controllers that react on player input
    private final ChickenController chickenController;
    private final EndLineController endLineController;

    private final List<Controller<Space>> autoControllers;

    public SpaceController(Space space) {
        super(space);

        ControllerFactory factory = new ControllerFactory(space);

        this.chickenController = factory.createChickenController();
        this.endLineController = factory.createEndLineController();
        this.autoControllers = factory.createAutoControllers();
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
                chickenController.step(game, action, time);
                endLineController.step(game, action, time);
                break;
            case PAUSE:
                game.setPrevious(game.getState());
                game.setState(new PauseState(new Pause()));
            default:
                break;
        }

        for (Controller<Space> controller : autoControllers) {
            controller.step(game, GUI.ACTION.NONE, time);
        }

        if (chickenDied()) {
            game.setLevel(1);
            game.setState(new GameOverState(new GameOver(new Loader("GameOverScreen").getLines())));
        }
    }
}