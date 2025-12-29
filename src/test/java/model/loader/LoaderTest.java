package model.loader;

import CrossyRoad.model.loader.Loader;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoaderTest {

    @Test
    void loadExistingFile() throws IOException {
        // Assume que tens um ficheiro de teste nos resources.
        // Se não tiveres, podes usar um que já exista (ex: o do menu)
        Loader loader = new Loader("loadscreen");

        List<String> lines = loader.getLines();

        assertNotNull(lines);
        assertFalse(lines.isEmpty(), "O ficheiro não deve estar vazio");
    }

    @Test
    void loadNonExistingFileThrowsException() {
        // Este teste foca-se especificamente no teu 'if (is == null)'
        String nonExistentFile = "nao_existente.txt";

        IOException exception = assertThrows(IOException.class, () -> {
            new Loader(nonExistentFile);
        });

        // Verifica se a mensagem de erro é a que definiste no código
        assertTrue(exception.getMessage().contains("Ficheiro não encontrado"));
    }

    @Test
    void getLinesReturnsCorrectList() throws IOException {
        // Teste para garantir que o getter funciona e mantém a integridade
        Loader loader = new Loader("loadscreen");
        List<String> lines = loader.getLines();

        assertEquals(lines, loader.getLines(), "Deve retornar a mesma lista de linhas");
    }
}