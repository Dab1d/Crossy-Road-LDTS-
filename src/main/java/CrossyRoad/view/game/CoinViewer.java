package CrossyRoad.view.game;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.Coin;

public class CoinViewer implements ElementViewer<Coin> {
    @Override
    public void draw(Coin coin, GUI gui){
        gui.drawCharacter(coin.getPosition().getX(), coin.getPosition().getY(), 'o', "#FFFF00");
    }
}
