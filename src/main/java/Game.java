import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private int width;
    private int height;

    public Game() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal(); //crate the terminal window
        this.screen = new TerminalScreen(terminal); // create the screen window based on the terminal

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

        //getting the terminal sizes and setting min values
        TerminalSize size = screen.getTerminalSize();
        this.width = Math.max(20, size.getColumns());
        this.height = Math.max(20, size.getRows());
    }

    /** mock testing constructor */
    public Game(Screen screen) {
        this.screen = screen;
        TerminalSize size = screen.getTerminalSize();
        this.width = Math.max(20, size.getColumns());
        this.height = Math.max(20, size.getRows());
    }

    public void draw() throws IOException {
        screen.clear(); // cleans the screen buffer
        //arena.draw();
        screen.refresh(); //update the screen with the new info

    }
    
    public void run() throws IOException {
        while (true) {
            draw();
            try {
                Thread.sleep(50); // 20fps cpu won't need to run 100%
            } catch (InterruptedException e) { //thread interruption
                e.printStackTrace();
            }
        }
    }

    /** Getters */

    public Screen getScreen() {
        return screen;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}
