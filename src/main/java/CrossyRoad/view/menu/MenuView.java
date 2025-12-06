package CrossyRoad.view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.view.Viewer;

import java.util.List;
import java.util.Map;


public class MenuView extends Viewer<Menu> {
    public MenuView(Menu model) {
        super(model);
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
                        default -> "#FFFFFF";
                    };
                    gui.drawPixel(x,y,color);
                }
            }
        }

        // Desenhar menu por cima
        gui.drawText(new Position(8, 1), "Menu", "#FFFFFF");
        gui.drawText(new Position(5, 28), "Press Enter", "#FFFFFF");
        gui.drawText(new Position(6, 29), "to Select", "#FFFFFF");
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(15, 11 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF"
            );
    }}
