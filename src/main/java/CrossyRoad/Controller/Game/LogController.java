package CrossyRoad.Controller.Game;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.game.elements.Log;
import CrossyRoad.model.game.elements.Truck;
import CrossyRoad.model.game.space.Space;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogController extends Controller<Space> {
    private final Map<Log, Integer> speeds = new HashMap<>();
    private final Map<Log, Boolean> directions = new HashMap<>();
    private long lastMoveTime = 0;

    public LogController(Space space) {
        super(space);
        List<Log> logs = getModel().getLogs();
        for (Log log : logs) {
            speeds.put(log, 1);        // velocidade padrão
            directions.put(log, true); // direção para a esquerda
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (time - lastMoveTime >= 200) { // move a cada 200ms
            moveLog();
            lastMoveTime = time;
        }
    }

    private void moveLog() {
        int width = getModel().getWidth();
        for (Log log : getModel().getLogs()) {
            Position pos = log.getPosition();
            int speed = speeds.get(log);
            boolean right = directions.get(log);

            int newX = right ? pos.getX() + speed : pos.getX() - speed;

            // wrap-around horizontal
            if (newX >= width) newX -= width;
            if (newX < 0) newX += width;

            pos.setX(newX); // y permanece igual
        }
    }
}
