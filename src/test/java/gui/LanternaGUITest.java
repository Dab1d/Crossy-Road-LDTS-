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
    void drawCharacter() {
        Position position = new Position(3, 4);

        gui.drawCharacter(position.getX(), position.getY(), 'a', "#FFFFFF");

        Mockito.verify(tg, Mockito.times(1))
                .setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));

        Mockito.verify(tg, Mockito.times(1))
                .putString(position.getX(), position.getY(), "a");

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
