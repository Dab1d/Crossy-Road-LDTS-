package controller.game;

import CrossyRoad.Controller.Game.LogController;
import CrossyRoad.Game;
import CrossyRoad.model.Position;
import CrossyRoad.model.game.elements.Chicken;
import CrossyRoad.model.game.elements.Log;
import CrossyRoad.model.game.space.Space;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

class LogControllerTest {

    private Space space;
    private LogController controller;
    private Game game;
    private Chicken chicken;

    @BeforeEach
    void setUp() {
        space = new Space(5, 5);

        // Inicializa todas as listas
        space.setBushes(new ArrayList<>());
        space.setCars(new ArrayList<>());
        space.setTrucks(new ArrayList<>());
        space.setLogs(new ArrayList<>());
        space.setRiver(new ArrayList<>());
        space.setEndLines(new ArrayList<>());
        space.setWalls(new ArrayList<>());
        space.setCoins(new ArrayList<>());

        chicken = new Chicken(2,2);
        space.setChicken(chicken);

        game = mock(Game.class);
    }

    @Test
    void step_movesLogAndChickenIfOnLog() {
        Log log = new Log(2,2);
        space.getLogs().add(log);              // adicionar **antes** do controller
        controller = new LogController(space); // criar controller depois

        controller.step(game, null, 500);

        // Log deve ter avançado
        assert(log.getPosition().getX() != 2);

        // Chicken deve ter se movido junto
        assert(chicken.getPosition().getX() == log.getPosition().getX());
    }

    @Test
    void step_movesLogWithoutChicken() {
        Log log = new Log(0,0);
        space.getLogs().add(log);
        controller = new LogController(space);

        controller.step(game, null, 500);

        assert(log.getPosition().getX() != 0);
        assert(chicken.getPosition().getX() == 2);
    }

    @Test
    void step_doesNotMoveIfNotEnoughTime() {
        Log log = new Log(1,1);
        space.getLogs().add(log);
        controller = new LogController(space);

        controller.step(game, null, 100);

        assert(log.getPosition().getX() == 1);
    }
}

