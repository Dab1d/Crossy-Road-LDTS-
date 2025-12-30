package model.menu;

import CrossyRoad.model.menu.Menu;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NavigableMenuTest {
    @Test
     void testSelectionLogic() {
        List<String> entries = Arrays.asList("Option 1", "Option 2");
        Menu menu = new Menu(entries);

        assertEquals(0, menu.getCurrentEntry());
        menu.nextEntry();
        assertEquals(1, menu.getCurrentEntry());
        assertTrue(menu.isSelected(1));
        assertFalse(menu.isSelected(0));
    }
}
