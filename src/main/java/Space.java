import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Space {

    private int width;
    private int height;
    private int min_x;
    private int max_x;
    private Chicken chicken;
    private List<Wall> walls;


    public Space(int width, int height) {
        this.width = width;
        this.height = height;
        this.chicken = new Chicken(10, 10);
        this.walls = creatWalls();
        updateLimits();
    }

    public void draw(TextGraphics graphics) throws IOException {
        /** background */
        graphics.setBackgroundColor(TextColor.Factory.fromString("#100091"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        /** Chicken*/
        chicken.draw(graphics);
        /** Walls*/
        for (Wall wall : walls) wall.draw(graphics);
    }

    private List<Wall> creatWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int c = 0; c < height; c++) {
            walls.add(new Wall(0, c));
            walls.add(new Wall(width - 1, c));
        }
        return walls;
    }

    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp -> moveChicken(chicken.moveUp());
            case ArrowDown -> moveChicken(chicken.moveDown());
            case ArrowLeft -> moveChicken(chicken.moveLeft());
            case ArrowRight -> moveChicken(chicken.moveRight());
        }
    }


    public void moveChicken(Position position) {
        if (canChickenMove(position))
            chicken.setPosition(position);

    }

    public boolean canChickenMove(Position position) {
        boolean inside = position.getX() >= min_x && position.getX() <= max_x && position.getY() > 0 && position.getY() < height;
        for (Wall parede : walls) {
            Position wp = parede.getPosition();
            if (wp.equals(position) || wp.equals(new Position(position.getX() + 1, position.getY()))) return false;
        }
        return inside;
    }
    /**
     * setters
     */
    public void setWidth(int width) {
        this.width = width;
        updateLimits();

    }

    public void setHeight(int height) {
        this.height = height;
        updateLimits();
    }

    private void updateLimits() {
        this.min_x = 1;
        this.max_x = width - 2;
    }

    /**
     * getters
     */
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getMin_x() {
        return min_x;
    }

    public int getMax_x() {
        return max_x;
    }
}
