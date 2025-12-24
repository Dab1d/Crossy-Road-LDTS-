package CrossyRoad.Controller.Game;

import CrossyRoad.Controller.Controller;
import CrossyRoad.model.game.space.Space;

import java.util.Arrays;
import java.util.List;

public class ControllerFactory {

    private final Space space;

    public ControllerFactory(Space space) {
        this.space = space;
    }

    public ChickenController createChickenController() {
        return new ChickenController(space);
    }

    public EndLineController createEndLineController() {
        return new EndLineController(space);
    }

    public List<Controller<Space>> createAutoControllers() {
        return Arrays.asList(
                new CarController(space),
                new TruckController(space),
                new LogController(space),
                new RiverController(space),
                new CoinController(space)
        );
    }
}