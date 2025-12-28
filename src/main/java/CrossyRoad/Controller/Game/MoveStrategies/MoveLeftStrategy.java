package CrossyRoad.Controller.Game.MoveStrategies;

import CrossyRoad.model.Position;

public class MoveLeftStrategy implements MoveStrategy{
    @Override
    public int move(Position position, int speed, int border){
        int x = position.getX() - speed;
        if ( x < 0) x = border -1;
        position.setX(x);
        return -speed;
    }
}
