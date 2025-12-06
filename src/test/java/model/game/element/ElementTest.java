package model.game.element;

import CrossyRoad.model.Position;
import CrossyRoad.model.game.elements.Element;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ElementTest {
    Element element;
    @BeforeEach
    void setUp() {
        this.element = new Element(5,5);
    }

    @Test
    void getPosition() {
        assertEquals(element.getPosition(), new Position(5,5));
        assertNotEquals(element.getPosition(), new Position(-5,5));
        assertNotEquals(element.getPosition(), new Position(-5,-5));
        assertNotEquals(element.getPosition(), new Position(4,5));
        assertNotEquals(element.getPosition(), new Position(5,6));
    }

    @Test
    void setPosition() {
        element.setPosition(new Position(6,6));
        assertEquals(element.getPosition(), new Position(6,6));
        assertNotEquals(element.getPosition(), new Position(-6,6));
        assertNotEquals(element.getPosition(), new Position(-6,-6));
        assertNotEquals(element.getPosition(), new Position(6,5));
        assertNotEquals(element.getPosition(), new Position(5,6));
        assertNotEquals(element.getPosition(), new Position(6,7));
        assertNotEquals(element.getPosition(), new Position(7,6));
    }

    @Test
    public void blockMovementTest() {
        assertTrue(!element.blockMovement());
        assertFalse(element.blockMovement());
    }
}
