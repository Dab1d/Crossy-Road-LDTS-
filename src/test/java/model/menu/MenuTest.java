package model.menu;

import CrossyRoad.model.loader.Loader;
import CrossyRoad.model.loader.ScreenType;
import CrossyRoad.model.menu.GameOver;
import CrossyRoad.model.menu.Menu;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    @Test
    public void testMenu() throws IOException {

        List<String> expectedLines = new Loader(ScreenType.MENU.getFile()).getLines();
        Menu menu = new Menu(expectedLines);

        assertEquals(expectedLines, menu.getBackground());
        assertEquals(0, menu.getCurrentEntry());
        assertEquals(3, menu.getNumberEntries());

        assertTrue(menu.isSelected(0));
        assertFalse(menu.isSelected(1));

        menu.previousEntry(); // 0 -> 2
        assertTrue(menu.isSelected(2));

        menu.nextEntry(); // 2 -> 0
        assertTrue(menu.isSelected(0));

        menu.nextEntry(); // 0 -> 1
        assertTrue(menu.isSelected(1));
        assertEquals("Start", menu.getEntry(0));
        assertEquals("Help", menu.getEntry(1));
        assertEquals("Exit", menu.getEntry(2));
    }
}
