package model.menu;

import CrossyRoad.model.loader.Loader;
import CrossyRoad.model.loader.ScreenType;
import CrossyRoad.model.menu.Win;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class WinTest {
    @Test
    public void testWin() throws IOException {
        Loader loader = new Loader(ScreenType.WIN.getFile());
        Win win = new Win(loader.getLines());

        win.previousEntry();
        assertTrue(win.isSelected(1), "Deveria estar selecionado o Exit ao retroceder do início");

        win.nextEntry();
        assertTrue(win.isSelected(0), "Deveria voltar ao Restart ao avançar do fim");

        assertEquals("Restart", win.getEntry(0));
        assertEquals("Exit", win.getEntry(1));

        assertEquals(2, win.getNumberEntries());
    }
}