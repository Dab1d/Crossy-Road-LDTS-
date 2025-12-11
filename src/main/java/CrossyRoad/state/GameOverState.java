package CrossyRoad.state;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Controller.Menu.GameOverController;
import CrossyRoad.model.menu.GameOver;
import CrossyRoad.view.Viewer;
import CrossyRoad.view.menu.GameOverView;

public class GameOverState extends State<GameOver> {
    public GameOverState(GameOver model) {
        super(model);
    }

    @Override
    public Viewer<GameOver> getViewer() {
        return new GameOverView(getModel());
    }

    @Override
    public Controller<GameOver> getController() {
        return new GameOverController(getModel());
    }
}
