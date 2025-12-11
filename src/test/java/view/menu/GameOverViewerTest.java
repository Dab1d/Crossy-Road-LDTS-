package view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.menu.GameOver;
import CrossyRoad.view.menu.GameOverView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class GameOverViewerTest {
    @Test
    public void gameOverViewerTest() {
        GUI gui = Mockito.mock(GUI.class);
        GameOver gameOver = new GameOver();

        GameOverView viewer = new GameOverView(gameOver);

        viewer.drawElements(gui);

        int y = 0;
        for (String line : viewer.getModel().getLines()) {
            verify(gui).drawText(new Position(0,y), line, (y == 0) ? "#FFF888" : "#FFFFFF");
            y++;
        }
    }
}
