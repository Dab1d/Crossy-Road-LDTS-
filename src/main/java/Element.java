import com.googlecode.lanterna.graphics.TextGraphics;
import java.io.IOException;

public abstract class Element {
    protected Position position;

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
    //default
    public abstract void draw(TextGraphics graphics) throws IOException;
}
