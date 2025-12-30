package model.menu;

import CrossyRoad.model.menu.GameOver;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverTest {

    @Test
    public void nextEntry_cyclesForward() {
        GameOver gameOver = new GameOver(List.of("bg"));
        assertTrue(gameOver.isSelected(0));
        gameOver.nextEntry();
        assertTrue(gameOver.isSelected(1));
        gameOver.nextEntry();
        assertTrue(gameOver.isSelected(0)); // deve voltar ao início
    }

    @Test
    public void previousEntry_cyclesBackward() {
        GameOver gameOver = new GameOver(List.of("bg"));
        assertTrue(gameOver.isSelected(0));
        gameOver.previousEntry();
        assertTrue(gameOver.isSelected(1)); // deve ir para a última entrada
        gameOver.previousEntry();
        assertTrue(gameOver.isSelected(0)); // volta ao início
    }

    @Test
    public void numberEntriesIsCorrect() {
        GameOver gameOver = new GameOver(List.of("bg"));
        assertEquals(2, gameOver.getNumberEntries());
    }

    @Test
    public void getEntryWorks() {
        GameOver gameOver = new GameOver(List.of("bg"));
        assertEquals("Restart", gameOver.getEntry(0));
        assertEquals("Exit", gameOver.getEntry(1));
    }
    @Test
    public void getBackgroundWorks() {
        List<String> mockBackground = List.of("line1", "line2");
        GameOver gameOver = new GameOver(mockBackground);

        List<String> result = gameOver.getBackground();

        assertEquals(mockBackground, result);
        assertEquals(2, result.size());
        assertEquals("line1", result.get(0));
    }
}

