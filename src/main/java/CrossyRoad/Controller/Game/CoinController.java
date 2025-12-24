package CrossyRoad.Controller.Game;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.game.elements.Coin;
import CrossyRoad.model.game.space.Space;

import java.util.Iterator;

public class CoinController extends Controller<Space> {

    public CoinController(Space space) {
        super(space);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        Position chickenPos = getModel().getChicken().getPosition();

        Iterator<Coin> it = getModel().getCoins().iterator();

        while (it.hasNext()) {
            Coin coin = it.next();
            if (coin.getPosition().equals(chickenPos)) {
                game.addScore();
                it.remove();
            }
        }
    }
}