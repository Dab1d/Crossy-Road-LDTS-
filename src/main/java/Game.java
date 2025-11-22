import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private int largura;
    private int altura;

    public Game() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal(); //crate the terminal window
        this.screen = new TerminalScreen(terminal); // create the screen window based on the terminal

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

        //getting the terminal sizes and setting min values
        TerminalSize tamanho = screen.getTerminalSize();
        this.largura = Math.max(20, tamanho.getColumns());
        this.altura = Math.max(20, tamanho.getRows());
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
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
