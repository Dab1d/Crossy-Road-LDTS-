package CrossyRoad.Controller.Game;

import CrossyRoad.Controller.Controller;
import CrossyRoad.state.StateManager;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.Truck;
import CrossyRoad.model.game.space.Space;

public class TruckController extends Controller<Space> {

    private long lastMoveTime = 0;

    public TruckController(Space space) {
        super(space);
    }

    @Override
    public void step(StateManager game, GUI.ACTION action, long time) {
        if (time - lastMoveTime >= 350) {
            for (Truck truck: getModel().getTruck()){
                truck.updatePosition(getModel().getWidth());
            }
            lastMoveTime = time;
        }
    }

}
