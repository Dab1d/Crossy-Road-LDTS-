package CrossyRoad.view.game;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.EndLine;

public class EndLineViewer implements ElementViewer<EndLine> {
    @Override
    public void draw(EndLine endLine, GUI gui) {
        gui.drawPixel(endLine.getPosition().getX(), endLine.getPosition().getY(), "#68FC86");
    }
}
