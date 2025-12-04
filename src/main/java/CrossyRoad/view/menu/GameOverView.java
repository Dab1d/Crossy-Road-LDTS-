package CrossyRoad.view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.menu.GameOver;
import CrossyRoad.view.Viewer;

public class GameOverView extends Viewer<GameOver> {
    public GameOverView(GameOver gameOver) {
        super(gameOver);
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
