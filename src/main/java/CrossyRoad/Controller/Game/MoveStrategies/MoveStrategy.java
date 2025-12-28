package CrossyRoad.Controller.Game.MoveStrategies;

import CrossyRoad.model.Position;

public interface  MoveStrategy {
    int move(Position  position, int speed, int border);
}
