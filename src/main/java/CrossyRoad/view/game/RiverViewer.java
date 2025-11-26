package CrossyRoad.view.game;


import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.River;

public class RiverViewer implements ElementViewer<River> {
    @Override
    public void draw(River river, GUI gui) {
        gui.drawRiver(river.getPosition());
    }
}