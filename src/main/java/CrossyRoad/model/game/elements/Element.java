package CrossyRoad.model.game.elements;

import CrossyRoad.model.Position;

public class Element implements Collider {
    private Position position;

    //constructor
    public Element(int x, int y) {
        this.position = new Position(x, y);
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public Position getPosition() {
        return position;
    }

    @Override
    public boolean blockMovement() {
        return false;
    }
}
