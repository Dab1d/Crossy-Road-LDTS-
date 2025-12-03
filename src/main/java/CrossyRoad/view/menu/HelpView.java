package CrossyRoad.view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.menu.Help;
import CrossyRoad.view.Viewer;

public class HelpView extends Viewer<Help> {

    public HelpView(Help help) {
        super(help);
    }

    @Override
    public void drawElements(GUI gui) {
        int y = 0;

        for (String line : getModel().getLines()) {
            String color = (y == 0) ? "#FFF888" : "#FFFFFF";
            gui.drawText(new Position(0, y), line, color);
            y++;
        }
    }
}
