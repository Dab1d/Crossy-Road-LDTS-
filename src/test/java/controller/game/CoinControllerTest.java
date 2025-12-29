package controller.game;

import CrossyRoad.Controller.Game.CoinController;
import CrossyRoad.state.StateManager;
import CrossyRoad.model.game.elements.Chicken;
import CrossyRoad.model.game.elements.Coin;
import CrossyRoad.model.game.space.Space;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CoinControllerTest {

    private Space space;
    private CoinController controller;
    private StateManager game;

    @BeforeEach
    void setUp() {
        space = new Space(5, 5);

        // Inicializa listas
        space.setBushes(new ArrayList<>());
        space.setCars(new ArrayList<>());
        space.setTrucks(new ArrayList<>());
        space.setLogs(new ArrayList<>());
        space.setRiver(new ArrayList<>());
        space.setEndLines(new ArrayList<>());
        space.setWalls(new ArrayList<>());

        // A lista de coins tem de ser mutável (ArrayList)
        space.setCoins(new ArrayList<>());

        Chicken chicken = new Chicken(2,2);
        space.setChicken(chicken);

        controller = new CoinController(space);
        game = mock(StateManager.class);
    }

    @Test
    void collectsCoinWhenChickenOnSamePosition() {
        Coin coin = new Coin(2,2);
        space.getCoins().add(coin);

        // Antes de executar, a lista tem 1 moeda
        assertEquals(1, space.getCoins().size());

        controller.step(game, null, 0);

        // VERIFICAÇÃO CORRETA:
        // 1. A moeda foi removida da lista?
        assertTrue(space.getCoins().isEmpty());

        // 2. O score foi aumentado?
        verify(game, times(1)).addScore();
    }

    @Test
    void doesNotCollectCoinWhenChickenNotOnCoin() {
        Coin coin = new Coin(1,1); // Galinha está em (2,2)
        space.getCoins().add(coin);

        controller.step(game, null, 0);

        // VERIFICAÇÃO CORRETA:
        // A lista ainda deve ter a moeda
        assertEquals(1, space.getCoins().size());
        assertTrue(space.getCoins().contains(coin));

        verify(game, never()).addScore();
    }

    @Test
    void collectingSameCoinTwiceDoesNotIncreaseScore() {
        Coin coin = new Coin(2,2);
        space.getCoins().add(coin);

        // Passo 1: Apanha a moeda
        controller.step(game, null, 0);

        // A moeda já foi removida aqui. A lista está vazia.

        // Passo 2: Tenta apanhar outra vez (mas a lista já não tem nada lá)
        controller.step(game, null, 0);

        // O score só deve ter sido chamado 1 vez (no primeiro step)
        verify(game, times(1)).addScore();

        // Garante que a lista continua vazia
        assertTrue(space.getCoins().isEmpty());
    }
}