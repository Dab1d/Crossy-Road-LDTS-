package model.menu;

import CrossyRoad.model.menu.Menu;
import CrossyRoad.model.menu.Pause;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
public class PauseTest {
    @Test
    public void testPause() {
        Pause pause = new Pause();

        pause.previousEntry();
        assertEquals(true, pause.isSelected(2));

        pause.nextEntry();
        assertEquals(true, pause.isSelected(0));

        pause.nextEntry();
        assertEquals(true, pause.isSelected(0));

        assertEquals("Resume", pause.getEntry(0));
        assertEquals("Menu", pause.getEntry(1));
        assertEquals("Quit", pause.getEntry(2));

        assertEquals(3, pause.getNumberEntries());
    }
}
*/