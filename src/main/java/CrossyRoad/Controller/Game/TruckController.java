package CrossyRoad.Controller.Game;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.Car;
import CrossyRoad.model.Position;
import CrossyRoad.model.game.elements.Truck;
import CrossyRoad.model.game.space.Space;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TruckController extends Controller<Space> {

    private long lastMoveTime = 0;

    public TruckController(Space space) {
        super(space);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (time - lastMoveTime >= 350) {
            for (Truck truck: getModel().getTruck()){
                truck.updatePosition(getModel().getWidth());
            }
            lastMoveTime = time;
        }
    }

}
