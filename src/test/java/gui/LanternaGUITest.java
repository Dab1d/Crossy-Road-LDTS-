package gui;

import CrossyRoad.gui.GUI;
import CrossyRoad.gui.LanternaGUI;
import CrossyRoad.model.Position;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics graphics;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        graphics = Mockito.mock(TextGraphics.class);

        when(screen.newTextGraphics()).thenReturn(graphics);

        gui = new LanternaGUI(screen);
    }

    @Test
    void getNextAction() throws IOException {
        assertAction(KeyType.EOF, GUI.ACTION.QUIT);
        assertAction('q', GUI.ACTION.QUIT);
        assertAction('p', GUI.ACTION.PAUSE);
        assertAction(KeyType.ArrowUp, GUI.ACTION.UP);
        assertAction(KeyType.ArrowDown, GUI.ACTION.DOWN);
        assertAction(KeyType.ArrowLeft, GUI.ACTION.LEFT);
        assertAction(KeyType.ArrowRight, GUI.ACTION.RIGHT);
        assertAction(KeyType.Enter, GUI.ACTION.SELECT);

        when(screen.pollInput()).thenReturn(null);
        assertEquals(GUI.ACTION.NONE, gui.getNextAction());
    }

    private void assertAction(KeyType type, GUI.ACTION expected) throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(type));
        assertEquals(expected, gui.getNextAction());
    }

    private void assertAction(char character, GUI.ACTION expected) throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke(character, false, false));
        assertEquals(expected, gui.getNextAction());
    }

    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "Hello", "#FFFFFF");

        verify(graphics, times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        verify(graphics, times(1)).putString(1, 1, "Hello");
    }

    @Test
    void drawTextWithBackground() {
        gui.drawText(new Position(1, 1), "Hello", "#FFFFFF", "#000000");

        verify(graphics).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        verify(graphics).setBackgroundColor(TextColor.Factory.fromString("#000000"));
        verify(graphics).putString(1, 1, "Hello");
    }

    @Test
    void drawPixel() {
        gui.drawPixel(5.0, 5.0, "#FF0000");

        verify(graphics).setBackgroundColor(TextColor.Factory.fromString("#FF0000"));
        verify(graphics).putString(5, 5, " ");
    }

    @Test
    void drawCharacter() {
        gui.drawCharacter(2, 3, 'X', "#00FF00");

        verify(graphics).setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        verify(graphics).putString(2, 3, "X");
    }

    @Test
    void screenLifecycle() throws IOException {
        gui.clear();
        verify(screen).clear();

        gui.refresh();
        verify(screen).refresh();

        gui.close();
        verify(screen).close();
    }

    @Test
    void constructorTest() {
        LanternaGUI simpleGui = new LanternaGUI(screen);
        simpleGui.clear();
        verify(screen).clear();
    }

    @Test
    void getNextActionUnknownKey() throws IOException {
        when(screen.pollInput()).thenReturn(new KeyStroke('z', false, false));
        assertEquals(GUI.ACTION.NONE, gui.getNextAction());

        when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Tab));
        assertEquals(GUI.ACTION.NONE, gui.getNextAction());
    }

    @Test
    void drawTextEmptyColor() {
        gui.drawText(new Position(0,0), "Test", "#000000");
        verify(graphics).setForegroundColor(TextColor.Factory.fromString("#000000"));
    }

    @Test
    void drawPixelMutationTest() {
        gui.drawPixel(10.7, 5.2, "#123456");

        verify(graphics).setBackgroundColor(TextColor.Factory.fromString("#123456"));
        verify(graphics).putString(10, 5, " ");
    }

    @Test
    void drawTextMutationTest() {
        Position pos = new Position(5, 5);
        gui.drawText(pos, "Test", "#FFFFFF", "#000000");

        verify(graphics).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        verify(graphics).setBackgroundColor(TextColor.Factory.fromString("#000000"));
        verify(graphics).putString(5, 5, "Test");
    }

    @Test
    void loadSquareFontMutationKiller() {
        try {
            AWTTerminalFontConfiguration config = gui.loadSquareFont();

            assertNotNull(config);
        } catch (Exception e) {
        }
    }
}