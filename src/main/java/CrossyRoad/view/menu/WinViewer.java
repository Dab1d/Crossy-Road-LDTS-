package CrossyRoad.view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.menu.Win;
import CrossyRoad.view.Viewer;

import java.util.List;

public class WinViewer extends Viewer<Win> {
    public WinViewer(Win win) {
        super(win);
    }

    @Override
    public void drawElements(GUI gui) {
        List<String> bg = getModel().getBackground();
        if (bg != null) {
            for (int y = 0; y < bg.size(); y++) {
                String line = bg.get(y);
                for (int x = 0; x < line.length(); x++) {
                    char c = line.charAt(x);

                    // Mapa de cores
                    String color = switch (c) {
                        case 'a' -> "#000000"; // og color#40E0D0
                        case 'b' -> "#000000";
                        case 'd' -> "#FF0000";
                        case 'f' -> "#FFFFFF";
                        case 'g' -> "#E59400";
                        case 'h' -> "#772D20";
                        case 'i' -> "#E0E0E0";
                        case 'j' -> "#B4B4B4";
                        case 'k' -> "#0047ab";
                        case 'n' -> "#ffba00";
                        case 'l'->"#ff9800";
                        case 'm'->"#00c1ff";
                        default -> "#FFFFFF";
                    };
                    gui.drawPixel(x, y, color);
                }
            }
        }

        for(int i = 0; i < getModel().getNumberEntries(); i++){
            gui.drawText(
                    new Position(2 + (10 * i), 9),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#F1E20E" : "#C4C4C4"
            );
        }
    }
}
