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

    private long lastMoveTime = 0;

    public LogController(Space space) {
        super(space);
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
        Position chickenPos = getModel().getChicken().getPosition();
        boolean chickenMoved = false;

        for (Log log : getModel().getLogs()) {

            boolean carryingChicken = !chickenMoved && chickenPos.equals(log.getPosition());
            int moveDelta = log.updatePosition(width);

            if (carryingChicken) {
                int newChickenX = chickenPos.getX() + moveDelta;

                 if (newChickenX < 0 || newChickenX >= width) {
                    getModel().isChickenDead();
                } else {
                    chickenPos.setX(newChickenX);
                }
                chickenMoved = true;
            }
        }
    }
}
