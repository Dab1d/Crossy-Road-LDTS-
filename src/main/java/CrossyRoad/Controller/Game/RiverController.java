package CrossyRoad.Controller.Game;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.model.Position;



import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class RiverController extends Controller<Space> {

    private final Map<Integer, Integer> riverSpeeds = new HashMap<>();
    private long lastMoveTime = 0;

    public RiverController(Space space) {
        super(space);
        // Cada linha do rio recebe uma velocidade
        for (int y : getModel().getRiverLinesY()) {
            riverSpeeds.put(y, 1);
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (time - lastMoveTime >= 200) {
            moveRivers();
            lastMoveTime = time;
        }
    }

    private void moveRivers() {
        int width = getModel().getWidth();
        for (int y : riverSpeeds.keySet()) {
            List<Position> line = getModel().getRiverPositionsAtLine(y);
            for (Position pos : line) {
                int newX = (pos.getX() + riverSpeeds.get(y)) % width;
                pos.setX(newX);
            }
        }
    }
}