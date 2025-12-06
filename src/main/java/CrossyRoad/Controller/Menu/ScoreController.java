package CrossyRoad.Controller.Menu;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.Score;

public class ScoreController extends Controller<Score> {

    public ScoreController(Score score) {
        super(score);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        switch (action) {
            case QUIT:
                getModel().reset();
                break;
            default:
                break;
        }
    }

    public void addPoints(int points) {
        getModel().addPoints(points); // increment score
    }
}
