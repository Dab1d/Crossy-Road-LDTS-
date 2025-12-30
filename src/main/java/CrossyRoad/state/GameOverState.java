package CrossyRoad.state;

import CrossyRoad.controller.Controller;
import CrossyRoad.model.menu.GameOver;
import CrossyRoad.view.Viewer;

public class GameOverState extends State<GameOver> {
    private final Controller<GameOver> controller;
    private final Viewer<GameOver> viewer;

    public GameOverState(GameOver model, Controller<GameOver> controller, Viewer<GameOver> viewer) {
        super(model);
        this.controller = controller;
        this.viewer = viewer;
    }

    @Override
    public Viewer<GameOver> getViewer() {
        return viewer;
    }

    @Override
    public Controller<GameOver> getController() {
        return this.controller;
    }
}