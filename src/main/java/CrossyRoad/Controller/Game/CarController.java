package CrossyRoad.Controller.Game;


import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.Car;
import CrossyRoad.model.game.space.Space;


public class CarController extends Controller<Space> {

    private long lastMoveTime = 0;

    public CarController(Space space) {
        super(space);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (time - lastMoveTime >= 100) {
            for (Car car : getModel().getCars()){
                car.updatePosition(getModel().getWidth());
            }
            lastMoveTime = time;
        }
    }
}
