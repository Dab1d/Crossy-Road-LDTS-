package CrossyRoad.view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.view.Viewer;

public class MenuView extends Viewer<Menu> {
    public MenuView(Menu model) {
        super(model);
    }

    @Override
    public void drawElements(GUI gui) {
        drawBackground(gui, getModel().getBackground());
        String bg = getModel().getBackgroundColor();
        gui.drawText(new Position(8, 1), "Menu", "#FFFFFF", bg);
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(
                    new Position(2 + i * 6, 4),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#00fef8" : "#FFFFFF", bg
            );
        }
    }
}