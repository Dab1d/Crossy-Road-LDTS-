package CrossyRoad.view.game;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.Bush;

public class BushViewer implements ElementViewer<Bush> {
    @Override
    public void draw(Bush bush, GUI gui) {
        gui.drawCharacter(bush.getPosition().getX(), bush.getPosition().getY(), '█', "#97D077");
    }

}
