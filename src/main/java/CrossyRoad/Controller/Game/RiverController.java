package CrossyRoad.Controller.Game;

import CrossyRoad.Controller.Controller;
import CrossyRoad.state.StateManager;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.River;
import CrossyRoad.model.game.space.Space;


public class RiverController extends Controller<Space> {
    private long lastMoveTime = 0;

    public RiverController(Space space) {
        super(space);
    }

    @Override
    public void step(StateManager game, GUI.ACTION action, long time) {
        if (time - lastMoveTime >= 200) {
            for (River river : getModel().getRiver()){
                river.updateRiver(getModel().getWidth());
            }
            lastMoveTime = time;
        }
    }


}