package model;

import CrossyRoad.model.Position;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    Position position;

    @BeforeEach
    void setUp() {
        this.position = new Position(5,5);
    }
    @Test
    void testGetLeft() {
        position = position.getLeft();

        assertEquals(4, position.getX());
        assertNotEquals(5, position.getX());
        assertNotEquals(6, position.getX());

        assertEquals(5, position.getY());
        assertNotEquals(4, position.getY());
        assertNotEquals(6, position.getY());
    }

    @Test
    void testGetRight() {
        position = position.getRight();
        assertEquals(6, position.getX());
        assertNotEquals(5, position.getX());
        assertNotEquals(4, position.getX());


        assertEquals(5, position.getY());
        assertNotEquals(6, position.getY());
        assertNotEquals(4, position.getY());
    }

    @Test
    void testGetUp() {
        position = position.getUp();
        assertEquals(5, position.getX());
        assertNotEquals(6, position.getX());
        assertNotEquals(4, position.getX());


        assertEquals(4, position.getY());
        assertNotEquals(6, position.getY());
        assertNotEquals(5, position.getY());
    }

    @Test
    void testGetDown() {
        position = position.getDown();
        assertEquals(5, position.getX());
        assertNotEquals(6, position.getX());
        assertNotEquals(4, position.getX());


        assertEquals(6, position.getY());
        assertNotEquals(5, position.getY());
        assertNotEquals(4, position.getY());
    }

    @Test
    void equalsTest() {
        Position testpos = new Position(5,5);

        assertTrue(testpos.equals(testpos));
        assertTrue(position.equals(position));

        assertFalse(testpos.equals(null));
        assertFalse(position.equals(null));
        assertFalse(position.equals(new Object()));

        assertTrue(position.equals(testpos));
        assertFalse(position.equals(testpos.getLeft()));
        assertFalse(position.equals(testpos.getRight()));
        assertFalse(position.equals(testpos.getUp()));
        assertFalse(position.equals(testpos.getDown()));
        assertTrue(position.getDown().equals(testpos.getDown()));
        assertTrue(position.getLeft().equals(testpos.getLeft()));
        assertTrue(position.getRight().equals(testpos.getRight()));
        assertTrue(position.getUp().equals(testpos.getUp()));

    }

    @Test
    void setXTest() {
        position.setX(6);
        assertEquals(6, position.getX());
        assertNotEquals(5, position.getX());
        assertNotEquals(4, position.getX());
        assertEquals(5, position.getY());
        assertNotEquals(6, position.getY());
        assertNotEquals(4, position.getY());
    }

    @Test
    void setYTest() {
        position.setY(6);
        assertEquals(6, position.getY());
        assertNotEquals(5, position.getY());
        assertNotEquals(4, position.getY());
        assertEquals(5, position.getX());
        assertNotEquals(6, position.getX());
        assertNotEquals(4, position.getX());
    }
}
