package CrossyRoad.state;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Controller.Game.SpaceController;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.view.Viewer;
import CrossyRoad.view.game.GameViewer;

public class GameState extends State<Space> {
    public GameState(Space space) {
        super(space);
    }

    @Override
    public Viewer<Space> getViewer() {
        return new GameViewer(getModel());
    }


    @Override
    public Controller<Space> getController() {
        return new SpaceController(getModel());
    }
}

