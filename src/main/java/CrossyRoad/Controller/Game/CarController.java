package CrossyRoad.Controller.Game;


import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.Car;
import CrossyRoad.model.Position;
import CrossyRoad.model.game.space.Space;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarController extends Controller<Space> {

    private final Map<Car, Integer> speeds = new HashMap<>();
    private final Map<Car, Boolean> directions = new HashMap<>();
    private long lastMoveTime = 0;

    public CarController(Space space) {
        super(space);
        List<Car> cars = getModel().getCars();
        for (Car car : cars) {
            speeds.put(car, 1);        // velocidade padrão
            directions.put(car, true); // direção para a direita
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (time - lastMoveTime >= 200) { // move a cada 200ms
            moveCars();
            lastMoveTime = time;
        }
    }

    private void moveCars() {
        int width = getModel().getWidth();
        for (Car car : getModel().getCars()) {
            Position pos = car.getPosition();
            int speed = speeds.get(car);
            boolean right = directions.get(car);

            int newX = right ? pos.getX() + speed : pos.getX() - speed;

            // wrap-around horizontal
            if (newX >= width) newX -= width;
            if (newX < 0) newX += width;

            pos.setX(newX); // y permanece igual
        }
    }
}
