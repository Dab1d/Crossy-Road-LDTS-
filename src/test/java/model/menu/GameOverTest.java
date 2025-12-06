package model.menu;

import CrossyRoad.model.menu.GameOver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class GameOverTest {
    @Test
    public void testGameOver() {
        GameOver gameOver = new GameOver();

        assertEquals(gameOver.getLines().size(), 5);
    }
}
