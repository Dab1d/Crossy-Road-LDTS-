package controller.game;

import CrossyRoad.Controller.Game.EndLineController;
import CrossyRoad.Game;
import CrossyRoad.model.Position;
import CrossyRoad.model.game.elements.Chicken;
import CrossyRoad.model.game.elements.EndLine;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.state.GameState;
import CrossyRoad.state.WinState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EndLineControllerTest {

    private Space space;
    private EndLineController controller;
    private Game game;

    @BeforeEach
    void setUp() {
        space = new Space(5, 5);

        // Inicializa todas as listas para não dar NullPointerException
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

        controller = new EndLineController(space);
        game = mock(Game.class);
    }

    @Test
    void step_advancesLevelIfNotLastLevel() throws IOException {
        EndLine endLine = new EndLine(2,2);
        space.getEndlines().add(endLine);

        when(game.getLevel()).thenReturn(1);

        controller.step(game, null, 0);

        verify(game).setLevel(2);
        verify(game).setState(any(GameState.class));
    }

    @Test
    void step_triggersWinIfLastLevel() throws IOException {
        EndLine endLine = new EndLine(2,2);
        space.getEndlines().add(endLine);

        when(game.getLevel()).thenReturn(5);

        controller.step(game, null, 0);

        verify(game).setState(any(WinState.class));
    }

    @Test
    void step_doesNothingIfChickenNotOnEndLine() throws IOException {
        EndLine endLine = new EndLine(1,1);
        space.getEndlines().add(endLine);

        when(game.getLevel()).thenReturn(3);

        controller.step(game, null, 0);

        verify(game, never()).setLevel(anyInt());
        verify(game, never()).setState(any());
    }
}

