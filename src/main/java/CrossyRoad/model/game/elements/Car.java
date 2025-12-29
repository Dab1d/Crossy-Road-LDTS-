package CrossyRoad.model.game.elements;

import CrossyRoad.controller.Game.MoveStrategies.MoveStrategy;

public class Car extends Element {

    private final int speed;
    private final MoveStrategy moveStrategy;

    //constructor
    public Car(int x, int y, int speed, MoveStrategy moveStrategy) {
        super(x, y);
        this.speed = speed;
        this.moveStrategy = moveStrategy;
    }

    public void updatePosition(int width) {
        moveStrategy.move(this.getPosition(), this.speed, width);
    }

}
