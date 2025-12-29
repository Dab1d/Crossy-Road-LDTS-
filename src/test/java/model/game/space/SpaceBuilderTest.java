package model.game.space;

import CrossyRoad.controller.Game.MoveStrategies.MoveRightStrategy;
import CrossyRoad.model.Position;
import CrossyRoad.model.game.elements.*;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.model.game.space.SpaceBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SpaceBuilderTest {

    class FakeBuilder extends SpaceBuilder {

        @Override
        public int getWidth() {
            return 20;
        }

        @Override
        public int getHeight() {
            return 15;
        }

        @Override
        public Chicken createChicken() {
            return new Chicken(1,1);
        }

        @Override
        public List<Wall> createWalls() {
            return List.of(new Wall(0,0));
        }

        @Override
        public List<Bush> createBushes() {
            return List.of(new Bush(2,2));
        }

        @Override
        public List<Log> createLog() {
            return List.of(new Log(3,3,1,new MoveRightStrategy()));
        }

        @Override
        public List<River> createRiver() {
            return List.of(new River(4,4,1,new MoveRightStrategy()));
        }

        @Override
        public List<Car> createCar() {
            return List.of(new Car(5,5,1,new MoveRightStrategy()));
        }

        @Override
        public List<Truck> createTruck() {
            return List.of(new Truck(6,6,1,new MoveRightStrategy()));
        }

        @Override
        public List<EndLine> createEndLine() {
            return List.of(new EndLine(7,7));
        }

        @Override
        public List<Coin> createCoin() {return List.of(new Coin(8,8));}
    }

    @Test
    void testCreateSpace() {
        FakeBuilder builder = new FakeBuilder();
        Space space = builder.createSpace();

        assertEquals(20, space.getWidth());
        assertEquals(15, space.getHeight());

        assertNotNull(space.getChicken());
        assertEquals(new Position(1, 1), space.getChicken().getPosition());

        assertEquals(1, space.getWalls().size());
        assertEquals(new Position(0, 0), space.getWalls().get(0).getPosition());

        assertEquals(1, space.getBushes().size());
        assertEquals(new Position(2, 2), space.getBushes().get(0).getPosition());

        assertEquals(1, space.getLogs().size());
        assertEquals(new Position(3, 3), space.getLogs().get(0).getPosition());

        assertEquals(1, space.getRiver().size());
        assertEquals(new Position(4, 4), space.getRiver().get(0).getPosition());

        assertEquals(1, space.getCars().size());
        assertEquals(new Position(5, 5), space.getCars().get(0).getPosition());

        assertEquals(1, space.getTruck().size());
        assertEquals(new Position(6, 6), space.getTruck().get(0).getPosition());

        assertEquals(1, space.getEndlines().size());
        assertEquals(new Position(7, 7), space.getEndlines().get(0).getPosition());

        assertEquals(1, space.getCoins().size());
        assertEquals(new Position(8, 8), space.getCoins().get(0).getPosition());
    }
}
