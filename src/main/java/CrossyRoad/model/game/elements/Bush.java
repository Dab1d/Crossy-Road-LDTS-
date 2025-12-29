package CrossyRoad.model.game.elements;

public class Bush extends Element {
    //constructor
    public Bush(int x,int y){
        super(x,y);
    }

    @Override
    public boolean blockMovement() {
        return true;
    }
}
