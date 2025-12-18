package controller.game;

import CrossyRoad.Controller.Game.ChickenController;
import CrossyRoad.Controller.Game.SpaceController;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.game.elements.Chicken;
import CrossyRoad.model.game.elements.Coin;
import CrossyRoad.model.game.elements.Bush;
import CrossyRoad.model.game.elements.Car;
import CrossyRoad.model.game.elements.Log;
import CrossyRoad.model.game.elements.Truck;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.model.game.elements.EndLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SpaceControllerTest {

    private Space space;
    private SpaceController controller;
    private Game game;

    @BeforeEach
    public void setUp() throws IOException, URISyntaxException, FontFormatException {
        space = new Space(10, 10);

        // Inicializa todas as listas do Space
        space.setBushes(new ArrayList<>());
        space.setCars(new ArrayList<>());
        space.setTrucks(new ArrayList<>());
        space.setLogs(new ArrayList<>());
        space.setRiver(new ArrayList<>());
        space.setEndLines(new ArrayList<>());
        space.setWalls(new ArrayList<>());
        space.setCoins(new ArrayList<>());

        // Coloca a galinha no centro
        space.setChicken(new Chicken(5,5));

        controller = new SpaceController(space);
        game = new Game(); // Certifica-te que Game pode ser instanciado assim
    }

    @Test
    public void moveChickenUp_whenEmpty() throws IOException {
        Position initial = new Position(space.getChicken().getPosition().getX(), space.getChicken().getPosition().getY());
        controller.step(game, GUI.ACTION.UP, 0);
        Position after = space.getChicken().getPosition();

        assertEquals(initial.getX(), after.getX());
        assertEquals(initial.getY() - 1, after.getY());
    }

    @Test
    public void moveChickenDown_whenEmpty() throws IOException {
        Position initial = new Position(space.getChicken().getPosition().getX(), space.getChicken().getPosition().getY());
        controller.step(game, GUI.ACTION.DOWN, 0);
        Position after = space.getChicken().getPosition();

        assertEquals(initial.getX(), after.getX());
        assertEquals(initial.getY() + 1, after.getY());
    }

    @Test
    public void moveChickenLeft_whenEmpty() throws IOException {
        Position initial = new Position(space.getChicken().getPosition().getX(), space.getChicken().getPosition().getY());
        controller.step(game, GUI.ACTION.LEFT, 0);
        Position after = space.getChicken().getPosition();

        assertEquals(initial.getX() - 1, after.getX());
        assertEquals(initial.getY(), after.getY());
    }

    @Test
    public void moveChickenRight_whenEmpty() throws IOException {
        Position initial = new Position(space.getChicken().getPosition().getX(), space.getChicken().getPosition().getY());
        controller.step(game, GUI.ACTION.RIGHT, 0);
        Position after = space.getChicken().getPosition();

        assertEquals(initial.getX() + 1, after.getX());
        assertEquals(initial.getY(), after.getY());
    }

    @Test
    public void chickenDoesNotMoveIntoBush() throws IOException {
        // Adiciona um bush onde a galinha iria mover-se
        space.getBushes().add(new Bush(5,4));
        Position initial = new Position(space.getChicken().getPosition().getX(), space.getChicken().getPosition().getY());

        controller.step(game, GUI.ACTION.UP, 0);
        Position after = space.getChicken().getPosition();

        // Galinha não se move
        assertEquals(initial.getX(), after.getX());
        assertEquals(initial.getY(), after.getY());
    }

    @Test
    public void coinIsCollected_whenChickenMoves() throws IOException {
        Coin coin = new Coin(5,4);
        space.getCoins().add(coin);

        controller.step(game, GUI.ACTION.UP, 0);

        // Verifica se a moeda foi "coletada" movendo-a para (-1, -1)
        assertEquals(-1, coin.getPosition().getX());
        assertEquals(-1, coin.getPosition().getY());
    }
}
