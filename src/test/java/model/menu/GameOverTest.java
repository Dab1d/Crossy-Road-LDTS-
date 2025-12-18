package model.menu;

import CrossyRoad.model.menu.GameOver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameOverTest {

    @Test
    public void nextEntry_cyclesForward() {
        GameOver gameOver = new GameOver();
        assertTrue(gameOver.isSelectedRestart());
        gameOver.nextEntry();
        assertTrue(gameOver.isSelectedExit());
        gameOver.nextEntry();
        assertTrue(gameOver.isSelectedRestart()); // deve voltar ao início
    }

    @Test
    public void previousEntry_cyclesBackward() {
        GameOver gameOver = new GameOver();
        assertTrue(gameOver.isSelectedRestart());
        gameOver.previousEntry();
        assertTrue(gameOver.isSelectedExit()); // deve ir para a última entrada
        gameOver.previousEntry();
        assertTrue(gameOver.isSelectedRestart()); // volta ao início
    }

    @Test
    public void numberEntriesIsCorrect() {
        GameOver gameOver = new GameOver();
        assertEquals(2, gameOver.getNumberEntries());
    }

    @Test
    public void getEntryWorks() {
        GameOver gameOver = new GameOver();
        assertEquals("Restart", gameOver.getEntry(0));
        assertEquals("Exit", gameOver.getEntry(1));
    }
}

