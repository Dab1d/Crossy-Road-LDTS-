package CrossyRoad.model.game.elements;

import CrossyRoad.Controller.Game.MoveStrategies.MoveStrategy;

public class River extends Element {
    private final int speed;
    private final MoveStrategy moveStrategy;

    public River(int x, int y, int speed, MoveStrategy moveStrategy) {
        super(x, y);
        this.speed = speed;
        this.moveStrategy = moveStrategy;
    }
    public void updateRiver(int width){
        moveStrategy.move(this.getPosition(), this.speed, width);
    }

}
