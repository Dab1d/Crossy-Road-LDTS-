package CrossyRoad.model.game.elements;

public class River extends Element {
    //constructor
    public River(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean blockMovement() {
        return true;
    }
}
