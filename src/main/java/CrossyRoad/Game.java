package CrossyRoad;

import CrossyRoad.gui.LanternaGUI;
import CrossyRoad.model.game.elements.Bush;
import CrossyRoad.model.game.elements.Log;
import CrossyRoad.model.game.elements.River;
import CrossyRoad.model.game.elements.*;
import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.game.space.Space;

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


            for (Bush bush : space.getBushes()) {
                gui.drawBush(bush.getPosition());
            }

            for (River river : space.getRiver()) {
                gui.drawRiver(river.getPosition());
            }
            for (Log log : space.getLogs()) {
                gui.drawLog(log.getPosition());
            }

            for (Car car : space.getCars()) {
                gui.drawCar(car.getPosition());
            }

            for (Truck truck : space.getTrucks()) {
                gui.drawTruck(truck.getPosition());
            }

            for (EndLine endLine : space.getEndlines()) {
                gui.drawEndLine(endLine.getPosition());
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
