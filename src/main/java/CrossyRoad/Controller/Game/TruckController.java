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

    private final Map<Truck, Integer> speeds = new HashMap<>();
    private final Map<Truck, Boolean> directions = new HashMap<>();
    private long lastMoveTime = 0;

    public TruckController(Space space) {
        super(space);
        List<Truck> trucks = getModel().getTruck();
        for (Truck truck : trucks) {
            speeds.put(truck, -1);        // velocidade padrão
            directions.put(truck, true); // direção para a esquerda
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (time - lastMoveTime >= 200) { // move a cada 200ms
            moveTruck();
            lastMoveTime = time;
        }
    }

    private void moveTruck() {
        int width = getModel().getWidth();
        for (Truck truck : getModel().getTruck()) {
            Position pos = truck.getPosition();
            int speed = speeds.get(truck);
            boolean right = directions.get(truck);

            int newX = right ? pos.getX() + speed : pos.getX() - speed;

            // wrap-around horizontal
            if (newX >= width) newX -= width;
            if (newX < 0) newX += width;

            pos.setX(newX); // y permanece igual
        }
    }
}
