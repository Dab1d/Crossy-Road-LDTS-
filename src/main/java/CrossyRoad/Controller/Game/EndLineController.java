package CrossyRoad.Controller.Game;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.model.game.elements.EndLine;
import CrossyRoad.model.menu.Win;
import CrossyRoad.state.GameState;
import CrossyRoad.state.WinState;

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
                if(game.getLevel() != 5){
                    game.setLevel(game.getLevel() + 1);
                    game.setState(new GameState(new LoaderSpaceBuilder(game.getLevel()).createSpace()));
                }
                else if(game.getLevel() == 5) game.setState(new WinState(new Win()));
            }
        }
    }
}
