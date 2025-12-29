package controller.game;

import CrossyRoad.Controller.Game.MoveStrategies.MoveRightStrategy;
import CrossyRoad.Controller.Game.RiverController;
import CrossyRoad.state.StateManager;
import CrossyRoad.model.game.elements.River;
import CrossyRoad.model.game.space.Space;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

class RiverControllerTest {

    private Space space;
    private RiverController controller;
    private StateManager game;

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

        game = mock(StateManager.class);
    }

    @Test
    void step_movesRiverPositions() {
        River r1 = new River(0,2,1,new MoveRightStrategy());
        River r2 = new River(1,2,1,new MoveRightStrategy());

        space.getRiver().add(r1);
        space.getRiver().add(r2);

        controller = new RiverController(space);

        controller.step(game, null, 500); // tempo suficiente para mover

        // Verifica que as posições foram atualizadas
        assert(r1.getPosition().getX() == 1);
        assert(r2.getPosition().getX() == 2);
    }
}
