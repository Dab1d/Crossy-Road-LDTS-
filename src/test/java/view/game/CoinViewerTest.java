package view.game;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.Coin;
import CrossyRoad.view.game.CoinViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class CoinViewerTest {
    @Test
    void chickenViewerDrawsCorrectCharacter() {
        GUI gui = Mockito.mock(GUI.class);
        Coin coin = new Coin(0,5);

        CoinViewer viewer = new CoinViewer();
        viewer.draw(coin, gui);

        verify(gui).drawCharacter(0, 5, 'o', "#FFFF00");
    }
}
