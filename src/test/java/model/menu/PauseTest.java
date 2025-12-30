package model.menu;

import CrossyRoad.model.menu.Pause;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PauseTest {
    @Test
    void testPauseInitialization() {

        Pause pause = new Pause();

        assertEquals(3, pause.getNumberEntries());
        assertEquals("Resume", pause.getEntry(0));
        assertEquals("Menu", pause.getEntry(1));
        assertEquals("Quit", pause.getEntry(2));
    }

    @Test
    void testInitialSelection() {
        Pause pause = new Pause();

        assertTrue(pause.isSelected(0));
        assertFalse(pause.isSelected(1));
        assertFalse(pause.isSelected(2));
    }
}