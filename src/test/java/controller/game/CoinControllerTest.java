package controller.game;

import CrossyRoad.Controller.Game.CoinController;
import CrossyRoad.Game;
import CrossyRoad.model.Position;
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
    private Game game;

    @BeforeEach
    void setUp() {
        space = new Space(5, 5);

        // Inicializa todas as listas para evitar NullPointerException
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

        controller = new CoinController(space);
        game = mock(Game.class);
    }

    @Test
    void collectsCoinWhenChickenOnSamePosition() {
        Coin coin = new Coin(2,2);
        space.getCoins().add(coin);

        controller.step(game, null, 0);

        assertTrue(controller.isCollected(coin));
        verify(game, times(1)).addScore();
        assertEquals(-1, coin.getPosition().getX());
        assertEquals(-1, coin.getPosition().getY());
    }

    @Test
    void doesNotCollectCoinWhenChickenNotOnCoin() {
        Coin coin = new Coin(1,1);
        space.getCoins().add(coin);

        controller.step(game, null, 0);

        assertFalse(controller.isCollected(coin));
        verify(game, never()).addScore();
        assertEquals(1, coin.getPosition().getX());
        assertEquals(1, coin.getPosition().getY());
    }

    @Test
    void collectingSameCoinTwiceDoesNotIncreaseScore() {
        Coin coin = new Coin(2,2);
        space.getCoins().add(coin);

        controller.step(game, null, 0);
        controller.step(game, null, 0);

        assertTrue(controller.isCollected(coin));
        verify(game, times(1)).addScore(); // só uma vez
    }
}

