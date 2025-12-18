package CrossyRoad.view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.menu.Pause;
import CrossyRoad.view.Viewer;

public class PauseViewer extends Viewer<Pause> {
    public PauseViewer(Pause pause) {
        super(pause);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(7, 5), "Pause", "#9FC1E9");

        gui.drawText(new Position(4, 25), "Press Enter", "#C4C4C4");
        gui.drawText(new Position(5, 26), "to Select", "#C4C4C4");


        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(7, 10 + 2*i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#F1E20E" : "#C4C4C4");
    }
}
