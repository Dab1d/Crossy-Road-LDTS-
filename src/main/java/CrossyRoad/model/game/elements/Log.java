package CrossyRoad.model.game.elements;

import CrossyRoad.controller.Game.MoveStrategies.MoveStrategy;

public class Log extends Element {
    private int speed;
    private MoveStrategy moveStrategy;
    //constructor
    public Log(int x, int y, int speed, MoveStrategy moveStrategy){
        super(x,y);
        this.speed = speed;
        this.moveStrategy = moveStrategy;
    }
    public int updatePosition(int width){
        return moveStrategy.move(this.getPosition(), this.speed, width);
    }


}
