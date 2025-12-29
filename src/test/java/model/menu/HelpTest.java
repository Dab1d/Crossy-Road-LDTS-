package model.menu;

import CrossyRoad.model.menu.Help;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HelpTest {

    @Test
    public void nextEntry_cyclesForward() {
        Help help = new Help();
        assertTrue(help.isSelected(0));
        help.nextEntry();
        assertTrue(help.isSelected(1));
        help.nextEntry();
        assertTrue(help.isSelected(0)); // volta ao início
    }

    @Test
    public void previousEntry_cyclesBackward() {
        Help help = new Help();
        assertTrue(help.isSelected(0));
        help.previousEntry();
        assertTrue(help.isSelected(1)); // vai para o final
        help.previousEntry();
        assertTrue(help.isSelected(0)); // volta ao início
    }

    @Test
    public void numberEntriesIsCorrect() {
        Help help = new Help();
        assertEquals(2, help.getNumberEntries());
    }

    @Test
    public void getEntryWorks() {
        Help help = new Help();
        assertEquals("Start", help.getEntry(0));
        assertEquals("Return", help.getEntry(1));
    }
}
