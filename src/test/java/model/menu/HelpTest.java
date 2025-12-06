package model.menu;

import CrossyRoad.model.menu.GameOver;
import CrossyRoad.model.menu.Help;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelpTest {
    @Test
    public void testHelp() {
        Help help = new Help();

        assertEquals(help.getLines().size(), 10);
    }
}
