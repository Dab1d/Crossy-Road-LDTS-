import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameTest {

    static Game game;

    /** initialize a game object */
    @BeforeAll
    static void beforeAll() throws IOException {
        game = new Game();
    }

    /** test the constructor */
    @Test
    public void testGameConstructor() throws IOException {
        assertNotNull(game.getScreen(), "Screen should not be null");
    }

    /** tests the minimal height */
    @Test
    public void testGameHeight() throws IOException {
        assertTrue(game.getHeight() >= 20, "Height should be greater or equal to 20");
    }

    /** tests the minimal width */
    @Test
    public void testGameWidth() throws IOException {
        assertTrue(game.getWidth() >= 20, "Width should be greater or equal to 20");
    }

    /** test the draw() methods */
    @Test
    public void testDrawCallsClearAndRefresh() throws IOException {
        Screen mockScreen = Mockito.mock(Screen.class);

        //mockito screen does not have get terminal size so we gave it one
        when(mockScreen.getTerminalSize()).thenReturn(new TerminalSize(80, 40));

        Game game = new Game(mockScreen); //constructor that accepts screen

        game.draw();

        verify(mockScreen).clear();
        verify(mockScreen).refresh();
    }
}
