package CrossyRoad.view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.loader.ColorAdapter;
import CrossyRoad.model.menu.GameOver;
import CrossyRoad.view.Viewer;

import java.util.List;

public class GameOverView extends Viewer<GameOver> {
    public GameOverView(GameOver gameOver) {
        super(gameOver);
    }

    @Override
    public void drawElements(GUI gui) {
        drawBackground(gui, getModel().getBackground());
        for(int i = 0; i < getModel().getNumberEntries(); i++){
            gui.drawText(
                    new Position(2 + (10 * i), 11),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#F1E20E" : "#C4C4C4"
            );
        }
    }
}
