package gui;

import CrossyRoad.gui.LanternaGUI;

import CrossyRoad.model.Position;
import CrossyRoad.model.game.elements.Car;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.virtual.VirtualTerminal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LanternaGUITest {

    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);
        gui = new LanternaGUI(screen);   // uses the constructor you provided
    }

    @Test
    void drawChicken() {
        Position pos = new Position(1, 1);
        gui.drawChicken(pos);

        Mockito.verify(tg, Mockito.times(1))
                .setForegroundColor(TextColor.Factory.fromString("#FF00FF"));

        Mockito.verify(tg, Mockito.times(1))
                .putString(1, 1, "C");
    }

    @Test
    void drawWalls() {
        Position pos = new Position(2, 2);
        gui.drawWalls(pos);

        Mockito.verify(tg, Mockito.times(1))
                .setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));

        Mockito.verify(tg, Mockito.times(1))
                .putString(2, 2, "#");
    }

    @Test
    void testDrawCar() {
        final String CAR_CHAR = "+";
        final String CAR_COLOR = "#C4A480";

        Position[] positions = {
                new Position(3, 3),
                new Position(5, 2),
                new Position(0, 0)
        };

        for (Position pos : positions) {
            gui.drawCar(pos);

            Mockito.verify(tg, Mockito.atLeastOnce())
                    .setForegroundColor(TextColor.Factory.fromString(CAR_COLOR));

            Mockito.verify(tg, Mockito.atLeastOnce())
                    .putString(pos.getX(), pos.getY(), CAR_CHAR);

            Mockito.reset(tg);
        }
    }

    @Test
    void drawText() {
        Position pos = new Position(3, 4);
        gui.drawText(pos, "Hello", "#336699");

        Mockito.verify(tg, Mockito.times(1))
                .setForegroundColor(TextColor.Factory.fromString("#336699"));

        Mockito.verify(tg, Mockito.times(1))
                .putString(3, 4, "Hello");
    }

    @Test
    void clear() {
        gui.clear();
        Mockito.verify(screen, Mockito.times(1)).clear();
    }

    @Test
    void refresh() throws IOException {
        gui.refresh();
        Mockito.verify(screen, Mockito.times(1)).refresh();
    }

    @Test
    void close() throws IOException {
        gui.close();
        Mockito.verify(screen, Mockito.times(1)).close();
    }
}
