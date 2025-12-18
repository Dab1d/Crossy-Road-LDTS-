package CrossyRoad.view.menu;

import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;

public class HUDView {
    public HUDView() {}
    public void draw(GUI gui, Game game) {
        gui.drawText(new Position(1,0), "Score: " + game.getScore(), "#E6E6FA");
        gui.drawText(new Position(11,0), "Level: " + game.getLevel(), "#E6E6FA");
    }
}
