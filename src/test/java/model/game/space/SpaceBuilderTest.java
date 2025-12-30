package model.game.space;

import CrossyRoad.controller.Game.MoveStrategies.MoveRightStrategy;
import CrossyRoad.model.game.elements.*;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.model.game.space.SpaceBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SpaceBuilderTest {

    class FakeBuilder extends SpaceBuilder {
        @Override
        public int getWidth() { return 20; }
        @Override
        public int getHeight() { return 15; }
        @Override
        public Chicken createChicken() { return new Chicken(1, 1); }
        @Override
        public List<Wall> createWalls() { return List.of(new Wall(0, 0)); }
        @Override
        public List<Bush> createBushes() { return List.of(new Bush(2, 2)); }
        @Override
        public List<Log> createLog() { return List.of(new Log(3, 3, 1, new MoveRightStrategy())); }
        @Override
        public List<River> createRiver() { return List.of(new River(4, 4, 1, new MoveRightStrategy())); }
        @Override
        public List<Car> createCar() { return List.of(new Car(5, 5, 1, new MoveRightStrategy())); }
        @Override
        public List<Truck> createTruck() { return List.of(new Truck(6, 6, 1, new MoveRightStrategy())); }
        @Override
        public List<EndLine> createEndLine() { return List.of(new EndLine(7, 7)); }
        @Override
        public List<Coin> createCoin() { return List.of(new Coin(8, 8)); }
    }

    @Test
    void testCreateSpaceComposition() {
        SpaceBuilder builder = new SpaceBuilder() {
            @Override
            protected int getWidth() { return 20; }

            @Override
            protected int getHeight() { return 30; }

            @Override
            protected List<Wall> createWalls() { return List.of(new Wall(1, 1)); }

            @Override
            protected Chicken createChicken() { return new Chicken(2, 2); }

            @Override
            protected List<Bush> createBushes() { return List.of(new Bush(3, 3)); }

            @Override
            protected List<River> createRiver() {
                return List.of(new River(4, 4, 1, null));
            }

            @Override
            protected List<Log> createLog() { return List.of(new Log(5, 5, 1, null)); }

            @Override
            protected List<Car> createCar() { return List.of(new Car(6, 6, 1, null)); }

            @Override
            protected List<Truck> createTruck() { return List.of(new Truck(7, 7, 1, null)); }

            @Override
            protected List<EndLine> createEndLine() { return List.of(new EndLine(8, 8)); }

            @Override
            protected List<Coin> createCoin() { return List.of(new Coin(9, 9)); }
        };

        Space space = builder.createSpace();

        assertEquals(20, space.getWidth());
        assertEquals(30, space.getHeight());
        assertNotNull(space.getChicken(), "Chicken setter não foi chamado");

        assertEquals(1, space.getWalls().size(), "Walls setter não foi chamado");
        assertEquals(1, space.getBushes().size(), "Bushes setter não foi chamado");

        assertNotNull(space.getRiver(), "Rivers list is null");
        assertEquals(1, space.getRiver().size(), "River setter não foi chamado");

        assertEquals(1, space.getLogs().size(), "Logs setter não foi chamado");
        assertEquals(1, space.getCars().size(), "Cars setter não foi chamado");
        assertEquals(1, space.getTruck().size(), "Trucks setter não foi chamado");
        assertEquals(1, space.getEndlines().size(), "EndLines setter não foi chamado");
        assertEquals(1, space.getCoins().size(), "Coins setter não foi chamado");
    }
}