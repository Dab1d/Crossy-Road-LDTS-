package CrossyRoad.Controller.Game;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.game.space.Space;

public class ChickenController extends Controller<Space> {
    public ChickenController(Space space) {
        super(space);
    }

    public void moveChickenLeft() {
        moveChicken(getModel().getChicken().getPosition().getLeft());
    }

    public void moveChickenRight() {
        moveChicken(getModel().getChicken().getPosition().getRight());
    }

    public void moveChickenUp() {
        moveChicken(getModel().getChicken().getPosition().getUp());
    }

    public void moveChickenDown() {
        moveChicken(getModel().getChicken().getPosition().getDown());
    }

    private void moveChicken(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getChicken().setPosition(position);
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) moveChickenUp();
        if (action == GUI.ACTION.RIGHT) moveChickenRight();
        if (action == GUI.ACTION.DOWN) moveChickenDown();
        if (action == GUI.ACTION.LEFT) moveChickenLeft();
    }
}
