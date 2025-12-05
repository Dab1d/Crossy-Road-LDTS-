package CrossyRoad.view.game;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.Chicken;

public class ChickenViewer implements ElementViewer<Chicken> {
    @Override
    public void draw(Chicken chicken, GUI gui) {
        gui.drawCharacter(chicken.getPosition().getX(), chicken.getPosition().getY(), 'G', "#FF00FF");
    }
}
