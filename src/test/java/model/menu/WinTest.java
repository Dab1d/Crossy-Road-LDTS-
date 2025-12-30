package model.menu;

import CrossyRoad.model.menu.Win;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinTest {

    @Test
    void testWinModel() {
        List<String> backgroundSimulado = Arrays.asList("linha1", "linha2");

        Win win = new Win(backgroundSimulado);

        assertEquals(backgroundSimulado, win.getBackground());
        assertEquals(2, win.getNumberEntries());
        assertEquals("Restart", win.getEntry(0));
        assertEquals("Exit", win.getEntry(1));
    }
}
