package controller.game;

import CrossyRoad.controller.Game.SpaceController;
import CrossyRoad.model.game.elements.Car;
import CrossyRoad.session.GameSession;
import CrossyRoad.state.StateManager;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.game.elements.Bush;
import CrossyRoad.model.game.elements.Chicken;
import CrossyRoad.model.game.elements.Coin;
import CrossyRoad.model.game.space.Space;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SpaceControllerTest {

    private Space space;
    private SpaceController controller;
    private StateManager game;
    private GameSession session;

    @BeforeEach
    public void setUp() {
        space = new Space(10, 10);

        // Inicializa todas as listas para evitar NullPointer
        space.setBushes(new ArrayList<>());
        space.setCars(new ArrayList<>());
        space.setTrucks(new ArrayList<>());
        space.setLogs(new ArrayList<>());
        space.setRiver(new ArrayList<>());
        space.setEndLines(new ArrayList<>());
        space.setWalls(new ArrayList<>());
        space.setCoins(new ArrayList<>()); // Lista mutável para o teste da moeda

        // Coloca a galinha no centro (5, 5)
        space.setChicken(new Chicken(6,5));

        // Cria o controller real
        controller = new SpaceController(space);

        // MOCK do Game (Simula o jogo sem abrir janelas reais)
        game = mock(StateManager.class);
        session = mock(GameSession.class);
        when(game.getGameSession()).thenReturn(session);
    }

    @Test
    public void moveChickenUp_whenEmpty() throws IOException {
        Position initial = new Position(6, 5);

        // Ação
        controller.step(game, GUI.ACTION.UP, 0);

        Position after = space.getChicken().getPosition();

        // Verifica (y diminui ao subir)
        assertEquals(initial.getX(), after.getX());
        assertEquals(initial.getY() - 1, after.getY());
    }

    @Test
    public void moveChickenDown_whenEmpty() throws IOException {
        Position initial = new Position(6, 5);

        controller.step(game, GUI.ACTION.DOWN, 0);
        Position after = space.getChicken().getPosition();

        assertEquals(initial.getX(), after.getX());
        assertEquals(initial.getY() + 1, after.getY());
    }

    @Test
    public void moveChickenLeft_whenEmpty() throws IOException {
        Position initial = new Position(6, 5);

        controller.step(game, GUI.ACTION.LEFT, 0);

        Position after = space.getChicken().getPosition();

        assertEquals(initial.getX() - 1, after.getX());
        assertEquals(initial.getY(), after.getY());
    }

    @Test
    public void moveChickenRight_whenEmpty() throws IOException {
        Position initial = new Position(6, 5);

        controller.step(game, GUI.ACTION.RIGHT, 0);

        Position after = space.getChicken().getPosition();

        assertEquals(initial.getX() + 1, after.getX());
        assertEquals(initial.getY(), after.getY());
    }

    @Test
    public void chickenDoesNotMoveIntoBush() throws IOException {
        space.getBushes().add(new Bush(6,4));
        Position initial = new Position(6, 5);
        // Tenta mover para cima
        controller.step(game, GUI.ACTION.UP, 0);
        Position after = space.getChicken().getPosition();

        assertEquals(initial.getX(), after.getX());
        assertEquals(initial.getY(), after.getY());
    }

    @Test
    public void coinIsCollected_whenChickenMoves() throws IOException {
        Coin coin = new Coin(6,4);
        space.getCoins().add(coin);
        assertFalse(space.getCoins().isEmpty());
        controller.step(game, GUI.ACTION.UP, 0);
        assertTrue(space.getCoins().isEmpty(), "A moeda devia ter sido removida");
        verify(session, times(1)).addScore();
    }

    @Test
    public void step_WhenPauseAction_ExecutesPauseCommand() throws IOException {
        controller.step(game, GUI.ACTION.PAUSE, 0);

        // O PauseCommand chama o pauseGame no StateManager
        verify(game, times(1)).pauseGame();
    }

    @Test
    public void step_WhenChickenCollidesWithCar_ExecutesLoseCommand() throws IOException {
        // 1. Obtém a posição atual da galinha
        Position chickenPos = space.getChicken().getPosition();

        // 2. Adiciona um carro na mesma posição
        // Passamos speed = 1 e moveStrategy = null porque não serão usados neste step
        space.getCars().add(new Car(chickenPos.getX(), chickenPos.getY(), 1, null));

        // 3. Executa o step (o SpaceController deve detetar a morte através do isChickenDead())
        controller.step(game, GUI.ACTION.NONE, 0);

        // 4. Verifica se o LoseCommand foi chamado
        verify(game, times(1)).loseGame();
    }

    @Test
    public void step_WhenChickenIsAlive_DoesNotExecuteLoseCommand() throws IOException {
        // 1. Garante que as listas de perigos estão vazias
        space.getCars().clear();
        space.getTruck().clear();
        space.getRiver().clear();

        // 2. Executa o step
        controller.step(game, GUI.ACTION.NONE, 0);

        // 3. Verifica que o loseGame NUNCA foi chamado
        verify(game, never()).loseGame();
    }
}