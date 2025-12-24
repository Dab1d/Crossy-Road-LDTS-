package CrossyRoad.view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;

public class HUDView {
    public HUDView() {}


    public void draw(GUI gui, int score, int level) {
        gui.drawText(new Position(1,0), "Score: " + score, "#E6E6FA");
        gui.drawText(new Position(11,0), "Level: " + level, "#E6E6FA");
    }
}