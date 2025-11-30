package CrossyRoad.state;

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
}
