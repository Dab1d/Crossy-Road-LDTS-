package CrossyRoad.view.game;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.Bush;
import CrossyRoad.model.game.elements.River;

public class RiverViewer implements ElementViewer<River> {
    @Override
    public void draw(River river, GUI gui) {
        gui.drawCharacter(river.getPosition().getX(), river.getPosition().getY(), '~', "#7EA6E0");
    }
}
