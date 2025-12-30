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
        // Line Coverage: addScore, getScore, resetScore

        // 1. Adicionar pontos
        gameSession.addScore();
        assertEquals(1, gameSession.getScore(), "Score deve ser 1 após adicionar");

        gameSession.addScore();
        assertEquals(2, gameSession.getScore(), "Score deve ser 2 após adicionar novamente");

        // 2. Resetar pontos
        gameSession.resetScore();
        assertEquals(0, gameSession.getScore(), "Score deve voltar a 0 após reset");
    }

    @Test
    void testLevelProgression() {
        // Branch Coverage (True): O if (!isMaxLevel()) é verdadeiro

        int initialLevel = gameSession.getLevel(); // 1
        gameSession.nextLevel();

        assertEquals(initialLevel + 1, gameSession.getLevel(), "Nível deve incrementar de 1 para 2");
        assertFalse(gameSession.isMaxLevel(), "Nível 2 não deve ser o máximo ainda");
    }

    @Test
    void testMaxLevelConstraint() {
        // Branch Coverage (False): O if (!isMaxLevel()) é falso
        // Path Coverage: Caminho até ao estado limite

        // O FINAL_LEVEL é 5. Estamos no 1.
        // Vamos avançar até ao 5.
        gameSession.nextLevel(); // 2
        gameSession.nextLevel(); // 3
        gameSession.nextLevel(); // 4
        gameSession.nextLevel(); // 5

        assertEquals(5, gameSession.getLevel());
        assertTrue(gameSession.isMaxLevel(), "Deve retornar true quando atinge o nível 5");

        // Tenta avançar quando já está no máximo (Branch False)
        gameSession.nextLevel();

        assertEquals(5, gameSession.getLevel(), "O nível não deve passar de 5");
    }

    @Test
    void testResetLevelOnly() {
        // Prepara um estado alterado
        gameSession.nextLevel(); // Nível 2
        assertNotEquals(1, gameSession.getLevel());

        // Executa resetLevel
        gameSession.resetLevel();

        // Verifica
        assertEquals(1, gameSession.getLevel(), "O nível deve voltar a 1");
    }

    @Test
    void testFullReset() {
        // Prepara um estado "sujo" (alterado)
        gameSession.addScore();
        gameSession.addScore(); // Score = 2
        gameSession.nextLevel(); // Level = 2

        // Executa reset total
        gameSession.reset();

        // Verifica se tudo voltou ao início
        assertEquals(0, gameSession.getScore(), "Score deve ser resetado");
        assertEquals(1, gameSession.getLevel(), "Level deve ser resetado");
    }
}