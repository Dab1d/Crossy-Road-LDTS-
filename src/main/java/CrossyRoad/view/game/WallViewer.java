package CrossyRoad.view.game;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall> {
    public void draw(Wall wall, GUI gui) {
        gui.drawCharacter(wall.getPosition().getX(), wall.getPosition().getY(), ' ', "#FFFFFF");
    }
}
