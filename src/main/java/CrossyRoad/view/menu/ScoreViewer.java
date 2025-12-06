package CrossyRoad.view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.menu.Score;
import CrossyRoad.view.Viewer;

public class ScoreViewer extends Viewer<Score> {

    public ScoreViewer(Score score) {
        super(score);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(0, 0), "Score: " + getModel().getPoints(), "#FFFF00");
    }
}
