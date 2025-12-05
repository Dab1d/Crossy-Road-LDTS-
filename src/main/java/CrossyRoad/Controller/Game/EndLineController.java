package CrossyRoad.Controller.Game;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.model.game.elements.EndLine;
import CrossyRoad.state.GameState;

import java.io.IOException;

public class EndLineController extends Controller<Space> {

    public EndLineController(Space space) {
        super(space);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        Position chickenPos = getModel().getChicken().getPosition();
        for (EndLine endline : getModel().getEndlines()) {
            if (chickenPos.equals(endline.getPosition())) {
                game.setState(new GameState(new LoaderSpaceBuilder(2).createSpace()));
            }
        }
    }
}
