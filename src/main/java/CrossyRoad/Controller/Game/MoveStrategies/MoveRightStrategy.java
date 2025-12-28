package CrossyRoad.Controller.Game.MoveStrategies;

import CrossyRoad.model.Position;

public class MoveRightStrategy implements MoveStrategy{
    @Override
    public int move(Position position, int speed, int border){
        int x = position.getX() + speed;
        if(x >= border) x = 0;
        position.setX(x);
        return speed;
    }
}
