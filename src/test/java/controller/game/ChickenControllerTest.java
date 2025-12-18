package controller.game;

import CrossyRoad.Controller.Game.ChickenController;
import CrossyRoad.model.Position;
import CrossyRoad.model.game.elements.Bush;
import CrossyRoad.model.game.elements.Chicken;
import CrossyRoad.model.game.space.Space;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ChickenControllerTest {

    private Space space;
    private ChickenController controller;

    @BeforeEach
    void setUp() {
        space = new Space(5, 5);

        // Inicializa listas para evitar NullPointerException
        space.setBushes(new ArrayList<>());
        space.setCars(new ArrayList<>());
        space.setTrucks(new ArrayList<>());
        space.setLogs(new ArrayList<>());
        space.setRiver(new ArrayList<>());
        space.setEndLines(new ArrayList<>());
        space.setWalls(new ArrayList<>());
        space.setCoins(new ArrayList<>());

        Chicken chicken = new Chicken(2,2);
        space.setChicken(chicken);

        controller = new ChickenController(space);
    }

    @Test
    void moveChickenUp_movesChickenUpIfEmpty() {
        Position before = space.getChicken().getPosition();
        controller.moveChickenUp();
        Position after = space.getChicken().getPosition();

        assertEquals(before.getX(), after.getX());
        assertEquals(before.getY() - 1, after.getY());
    }

    @Test
    void moveChickenLeft_movesChickenLeftIfEmpty() {
        Position before = space.getChicken().getPosition();
        controller.moveChickenLeft();
        Position after = space.getChicken().getPosition();

        assertEquals(before.getX() - 1, after.getX());
        assertEquals(before.getY(), after.getY());
    }

    @Test
    void moveChickenDoesNotMoveIntoBush() {
        // Adiciona um obstáculo
        space.getBushes().add(new Bush(2,1)); // em cima do chicken

        Position before = space.getChicken().getPosition();
        controller.moveChickenUp(); // tentar mover para bush
        Position after = space.getChicken().getPosition();

        assertEquals(before.getX(), after.getX());
        assertEquals(before.getY(), after.getY());
    }
}

