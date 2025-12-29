package CrossyRoad.view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.menu.Win;
import CrossyRoad.view.Viewer;

public class WinViewer extends Viewer<Win> {
    public WinViewer(Win win) {
        super(win);
    }

    @Override
    public void drawElements(GUI gui) {
        drawBackground(gui, getModel().getBackground());
        for(int i = 0; i < getModel().getNumberEntries(); i++){
            gui.drawText(
                    new Position(2 + (10 * i), 9),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#F1E20E" : "#C4C4C4"
            );
        }
    }
}
