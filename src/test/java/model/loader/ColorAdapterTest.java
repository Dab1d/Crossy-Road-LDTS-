package model.loader;

import CrossyRoad.model.loader.ColorAdapter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ColorAdapterTest {

    @ParameterizedTest
    @CsvSource({
            "a, #000000",
            "b, #000000",
            "d, #FF0000",
            "f, #FFFFFF",
            "g, #E59400",
            "h, #772D20",
            "i, #E0E0E0",
            "j, #B4B4B4",
            "k, #0047ab",
            "n, #ffba00",
            "l, #ff9800",
            "m, #00c1ff",
            "o, #ffae00",
            "p, #b914c8",
            "q, #d54d34",
            "z, #FFFFFF" // Testa o default (qualquer outra tecla)
    })
    void testGetHexColor(char code, String expectedHex) {
        assertEquals(expectedHex, ColorAdapter.getHexColor(code));
    }
}