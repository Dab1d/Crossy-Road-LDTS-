package CrossyRoad.model.game.elements;

import CrossyRoad.Controller.Game.MoveStrategies.MoveStrategy;
import CrossyRoad.model.Position;

public class Truck extends Element {

    private final int speed;
    private final MoveStrategy moveStrategy;

    public Truck(int x, int y, int speed, MoveStrategy moveStrategy) {
        super(x, y);
        this.speed = speed;
        this.moveStrategy = moveStrategy;
    }

    public void updatePosition(int width) {
        moveStrategy.move(this.getPosition(), this.speed, width);
    }
}
