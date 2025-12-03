package CrossyRoad.model.game.elements;

import CrossyRoad.model.Position;

public interface Collider {
    Position getPosition();
    boolean blockMovement();
}
