package CrossyRoad.view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.menu.GameOver;
import CrossyRoad.view.Viewer;

import java.util.List;

public class GameOverView extends Viewer<GameOver> {
    public GameOverView(GameOver gameOver) {
        super(gameOver);
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
                        default -> "#FFFFFF";
                    };
                    gui.drawPixel(x, y, color);
                }
            }
        }

        for(int i = 0; i < getModel().getNumberEntries(); i++){
            gui.drawText(
                    new Position(2 + (10 * i), 11),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFBA66" : "#2E89A6"
            );
        }
    }
}
