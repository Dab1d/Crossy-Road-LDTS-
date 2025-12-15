package CrossyRoad.view.menu;

import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;

public class HUDView {
    public HUDView() {}
    public void draw(GUI gui, Game game) {
        gui.drawText(new Position(0,0), "Score: " + game.getScore(), "#FFFFFF");
        gui.drawText(new Position(10,0), "Level: " + game.getLevel(), "#FFFFFF");
    }
}
