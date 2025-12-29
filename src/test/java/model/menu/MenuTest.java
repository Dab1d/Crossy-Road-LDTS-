package model.menu;

import CrossyRoad.model.loader.Loader;
import CrossyRoad.model.loader.ScreenType;
import CrossyRoad.model.menu.GameOver;
import CrossyRoad.model.menu.Menu;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {
    @Test
    public void testMenu() throws IOException {
        Loader loader = new Loader(ScreenType.MENU.getFile());
        Menu menu = new Menu(loader.getLines());


        menu.previousEntry();
        assertEquals(true, menu.isSelected(2));

        menu.nextEntry();
        assertEquals(true, menu.isSelected(0));

        menu.nextEntry();
        assertEquals(true, menu.isSelected(1));

        assertEquals("Start", menu.getEntry(0));
        assertEquals("Help", menu.getEntry(1));
        assertEquals("Exit", menu.getEntry(2));

        assertEquals(3, menu.getNumberEntries());
    }
}
