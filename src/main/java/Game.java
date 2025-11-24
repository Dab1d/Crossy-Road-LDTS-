import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.TerminalScrollController;

import java.io.IOException;
import java.security.Key;

public class Game {
    private Screen screen;
    private int width;
    private int height;
    private boolean running = true;

    private Space space;

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

        this.space = new Space(width, height); // create the game space
    }

    /**
     * mock testing constructor
     */
    public Game(Screen screen) {
        this.screen = screen;
        screen.setCursorPosition(null);//hide the cursor
        TerminalSize size = screen.getTerminalSize();
        this.width = Math.max(20, size.getColumns());
        this.height = Math.max(20, size.getRows());

        this.space = new Space(width, height);
    }

    public void draw() throws IOException {
        screen.clear(); // cleans the screen buffer
        TextGraphics textGraphics = screen.newTextGraphics(); // create TextGraphics that will be passed to the space

        TerminalSize newSize = screen.doResizeIfNecessary(); // returns null if screen did not change dimensios
        if (newSize != null) { // if changed dimensions draw the new space with the new dimension;
            TerminalSize size = screen.getTerminalSize();
            space.setWidth(size.getColumns());
            space.setHeight(size.getRows());
        }
        space.draw(textGraphics); //draw the game space

        screen.refresh(); //update the screen with the new info
    }

    private void processKey(KeyStroke key) {
        System.out.println("Recebi tecla: " + key); // DEBUG
        space.processKey(key);
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
            running = false;
    }


    public void run() throws IOException {
        while (running) {
            KeyStroke key = screen.pollInput(); // does not block if does not get a key
            if (key != null) { //if a key is pressed process it
                processKey(key);
            }

            draw();

            try {
                Thread.sleep(50); // 20fps cpu won't need to run 100%
            } catch (InterruptedException e) { //thread interruption
                e.printStackTrace();
            }
        }
        screen.stopScreen();

    }

    /**
     * Getters
     */

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
