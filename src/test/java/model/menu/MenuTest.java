package model.menu;

import CrossyRoad.model.menu.GameOver;
import CrossyRoad.model.menu.Menu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {
    @Test
    public void testMenu() {
        Menu menu = new Menu();

        menu.previousEntry();
        assertEquals(true, menu.isSelectedExit());

        menu.nextEntry();
        assertEquals(true, menu.isSelectedStart());

        menu.nextEntry();
        assertEquals(true, menu.isSelectedHelp());

        assertEquals("Start", menu.getEntry(0));
        assertEquals("Help", menu.getEntry(1));
        assertEquals("Exit", menu.getEntry(2));

        assertEquals(3, menu.getNumberEntries());
    }
}
