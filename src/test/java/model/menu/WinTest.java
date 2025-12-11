package model.menu;

import CrossyRoad.model.menu.Menu;
import CrossyRoad.model.menu.Win;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinTest {
    @Test
    public void testWin() {
        Win win = new Win();

        win.previousEntry();
        assertEquals(true, win.isSelectedExit());

        win.nextEntry();
        assertEquals(true, win.isSelectedRestart());


        assertEquals("Restart", win.getEntry(0));
        assertEquals("Exit", win.getEntry(1));

        assertEquals(2, win.getNumberEntries());
    }
}
