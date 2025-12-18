package CrossyRoad.Controller.Game;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.game.elements.Chicken;
import CrossyRoad.model.game.elements.Coin;
import CrossyRoad.model.game.space.Space;

import java.util.HashSet;
import java.util.Set;

public class CoinController extends Controller<Space> {
    private final Set<Coin> collectedCoins = new HashSet<>();

    public CoinController(Space space) {
        super(space);
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        Position chickenPos = getModel().getChicken().getPosition();

        for (Coin coin : getModel().getCoins()) {
            if (!collectedCoins.contains(coin) && coin.getPosition().equals(chickenPos)) {
                collectedCoins.add(coin);
                game.addScore();
                
                coin.getPosition().setX(-1);
                coin.getPosition().setY(-1);
            }
        }
    }

    public boolean isCollected(Coin coin) {
        return collectedCoins.contains(coin);
    }
}
