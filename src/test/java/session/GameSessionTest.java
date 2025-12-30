package session;

import CrossyRoad.session.GameSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameSessionTest {

    private GameSession gameSession;

    @BeforeEach
    void setUp() {
        gameSession = new GameSession();
    }

    @Test
    void testInitialization() {
        // Testa o construtor e os valores iniciais
        assertEquals(0, gameSession.getScore(), "O score inicial deve ser 0");
        assertEquals(1, gameSession.getLevel(), "O nível inicial deve ser 1");
    }

    @Test
    void testScoreMechanics() {
        gameSession.addScore();
        assertEquals(1, gameSession.getScore(), "Score deve ser 1 após adicionar");

        gameSession.addScore();
        assertEquals(2, gameSession.getScore(), "Score deve ser 2 após adicionar novamente");

        gameSession.resetScore();
        assertEquals(0, gameSession.getScore(), "Score deve voltar a 0 após reset");
    }

    @Test
    void testLevelProgression() {
        int initialLevel = gameSession.getLevel(); 
        gameSession.nextLevel();

        assertEquals(initialLevel + 1, gameSession.getLevel(), "Nível deve incrementar de 1 para 2");
        assertFalse(gameSession.isMaxLevel(), "Nível 2 não deve ser o máximo ainda");
    }

    @Test
    void testMaxLevelConstraint() {
        gameSession.nextLevel(); // lvl.2
        gameSession.nextLevel(); // lvl.3
        gameSession.nextLevel(); // lvl.4
        gameSession.nextLevel(); // lvl.5

        assertEquals(5, gameSession.getLevel());
        assertTrue(gameSession.isMaxLevel(), "Deve retornar true quando atinge o nível 5");

        gameSession.nextLevel();
        assertEquals(5, gameSession.getLevel(), "O nível não deve passar de 5");
    }

    @Test
    void testResetLevelOnly() {
        gameSession.nextLevel();
        assertNotEquals(1, gameSession.getLevel());
        
        gameSession.resetLevel();
        assertEquals(1, gameSession.getLevel(), "O nível deve voltar a 1");
    }

    @Test
    void testFullReset() {
        gameSession.addScore();
        gameSession.addScore(); 
        gameSession.nextLevel(); 
        gameSession.reset();

        assertEquals(0, gameSession.getScore(), "Score deve ser resetado");
        assertEquals(1, gameSession.getLevel(), "Level deve ser resetado");
    }
}
