package CrossyRoad;

import CrossyRoad.gui.LanternaGUI;
import CrossyRoad.model.Position;


import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(20,20);
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        new Game().start();
    }

    public void start() throws IOException {
        while(true){
            gui.clear();

            gui.drawChicken(new Position(10,10));

            for (int c = 0; c < 20; c++) {
                gui.drawWalls(new Position(c, 0));
                gui.drawWalls(new Position(c, 20 - 1));
            }
            for (int c = 0; c < 20; c++) {
                gui.drawWalls(new Position(0, c));
                gui.drawWalls(new Position(20 - 1, c));
            }

            gui.refresh();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

