package CrossyRoad;

import CrossyRoad.gui.LanternaGUI;
import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.model.game.elements.Wall;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private final Space space;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.space = new LoaderSpaceBuilder(1).createSpace();
        this.gui = new LanternaGUI(space.getWidth(), space.getHeight());
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        new Game().start();
    }

    public void start() throws IOException {
        while (true) {
            gui.clear();

            gui.drawChicken(space.getChicken().getPosition());

            for (Wall wall : space.getWalls()) {
                gui.drawWalls(wall.getPosition());
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
