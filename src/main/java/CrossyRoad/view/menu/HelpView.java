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

        gui.drawText(new Position(4, 1), "Crossy Road", "#F2BD97");
        gui.drawText(new Position(3, 3), "Avoid cars and", "#C4C4C4");
        gui.drawText(new Position(3, 4), "trucks while", "#C4C4C4");
        gui.drawText(new Position(2, 5), "collecting coins", "#C4C4C4");
        gui.drawText(new Position(2, 6), "Reach the end to", "#C4C4C4");
        gui.drawText(new Position(2, 7), "save the chicken", "#C4C4C4");


        gui.drawText(new Position(3, 14), " Instructions", "#F2BD97");

        gui.drawText(new Position(3, 16), "Use arrow keys", "#C4C4C4");
        gui.drawText(new Position(1, 17), "to move the chiken", "#C4C4C4");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(
                    new Position(4 + i * 6, 25),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#F1E20E" : "#C4C4C4"
            );
        }
    }
}

