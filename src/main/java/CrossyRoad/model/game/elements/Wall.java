package CrossyRoad.model.game.elements;

public class Wall extends Element {
    //constructor
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean blockMovement() {
        return true;
    }
}
