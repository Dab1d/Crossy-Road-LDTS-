package model.game.element;

import CrossyRoad.model.game.elements.EndLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class EndLineTest {
    EndLine endLine;
    @BeforeEach
    public void setUp() {
        this.endLine = new EndLine(5,5);
    }

    @Test
    public void testConstructor() {
        assertEquals(endLine.getPosition().getX(), 5 );
        assertFalse( endLine.getPosition().getX() == 6);
        assertFalse( endLine.getPosition().getX() == 4);


        assertEquals(endLine.getPosition().getY(), 5);
        assertFalse( endLine.getPosition().getY() == 6);
        assertFalse( endLine.getPosition().getY() == 4);
    }
}
