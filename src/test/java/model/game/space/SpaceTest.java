package model.game.space;
import CrossyRoad.Controller.Game.MoveStrategies.MoveLeftStrategy;
import CrossyRoad.Controller.Game.MoveStrategies.MoveRightStrategy;
import CrossyRoad.model.Position;
import CrossyRoad.model.game.elements.*;
import CrossyRoad.model.game.space.Space;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SpaceTest {

    private Space space;

    @BeforeEach
    void setup() {
        space = new Space(10, 10);

        space.setBushes(new ArrayList<>());
        space.setCars(new ArrayList<>());
        space.setTrucks(new ArrayList<>());
        space.setRiver(new ArrayList<>());
        space.setLogs(new ArrayList<>());
        space.setEndLines(new ArrayList<>());
        space.setWalls(new ArrayList<>());
        space.setCoins(new ArrayList<>());

        space.setChicken(new Chicken(5,5));
    }

    @Test
    void testIsEmptyTrue() {
        Position pos = new Position(1, 1);
        assertTrue(space.isEmpty(pos));
    }

    @Test
    void testIsEmptyFalseBecauseOfBush() {
        Bush bush = new Bush(2,2);
        space.getBushes().add(bush);

        assertFalse(space.isEmpty(new Position(2, 2)));
    }

    @Test
    void testChickenDiesByCar() {
        Car car = new Car(5,5,1,new MoveRightStrategy());
        space.getCars().add(car);

        assertTrue(space.isChickenDead());
    }

    @Test
    void testChickenDiesByTruck() {
        Truck truck = new Truck(5,5,1,new MoveLeftStrategy());
        space.getTruck().add(truck);

        assertTrue(space.isChickenDead());
    }

    @Test
    void testChickenDiesByRiver() {
        River river = new River(5,5,1,new MoveRightStrategy());
        space.getRiver().add(river);

        assertTrue(space.isChickenDead());
    }

    @Test
    void testChickenNotDead() {
        assertFalse(space.isChickenDead());
    }

    @Test
    void testReachedEndLineTrue() {
        EndLine endLine = new EndLine(5,5);
        space.getEndlines().add(endLine);

        assertTrue(space.reachedEndLine());
    }

    @Test
    void testReachedEndLineFalse() {
        EndLine endLine = new EndLine(0,0);
        space.getEndlines().add(endLine);

        assertFalse(space.reachedEndLine());
    }

    @Test
    void testGetRiverLinesY() {
        space.getRiver().add(new River(0,3,1,new MoveRightStrategy()));
        space.getRiver().add(new River(1,3,1,new MoveRightStrategy()));
        space.getRiver().add(new River(2,4,1,new MoveRightStrategy()));

        int[] lines = space.getRiverLinesY();

        assertEquals(3, lines.length);
        assertEquals(3, lines[0]);
        assertEquals(3, lines[1]);
        assertEquals(4, lines[2]);
    }

    @Test
    void testGetRiverPositionsAtLine() {
        space.getRiver().add(new River(0,2,1,new MoveRightStrategy()));
        space.getRiver().add(new River(1,2,1,new MoveRightStrategy()));
        space.getRiver().add(new River(3,4,1,new MoveRightStrategy()));

        List<Position> positions = space.getRiverPositionsAtLine(2);

        assertEquals(2, positions.size());
        assertTrue(positions.contains(new Position(0, 2)));
        assertTrue(positions.contains(new Position(1, 2)));
    }

    @Test
    void testgetWidth() {
        space.getWidth();
        assertEquals(space.getWidth(), 10);
        assertFalse(space.getWidth() == 11);
        assertFalse(space.getWidth() == -10);
    }

    @Test
    void testgetHeight() {
        space.getHeight();
        assertEquals(space.getHeight(), 10);
        assertFalse(space.getHeight() == 11);
        assertFalse(space.getHeight() == -10);
    }


    @Test
    void testgetChicken(){
        Chicken chinken = space.getChicken();
        assertEquals(space.getChicken(), chinken);
        assertEquals(space.getChicken().getPosition(), chinken.getPosition());
    }

    @Test
    void testgetLogs(){
        space.getLogs().add(new Log(1,1,1,new MoveRightStrategy()));
        List<Log> log = space.getLogs();
        assertEquals(space.getLogs().size(), 1);
        assertEquals(space.getLogs().get(0).getPosition(), new Position(1,1));
    }

    @Test
    void testgetWalls(){
        space.getWalls().add(new Wall(2,2));
        assertEquals(space.getWalls().size(), 1);
        assertEquals(space.getWalls().get(0).getPosition(), new Position(2,2));
    }
}
