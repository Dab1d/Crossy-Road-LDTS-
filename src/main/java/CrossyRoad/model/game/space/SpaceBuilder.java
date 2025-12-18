package CrossyRoad.model.game.space;

import CrossyRoad.model.game.elements.*;

import java.util.List;

/**
 * pode nao ser necessário implementar se nao fizemos niveis
 */
public abstract class SpaceBuilder {
    public Space createSpace() {
        Space space = new Space(getWidth(), getHeight());
        space.setChicken(createChicken());
        space.setWalls(createWalls());
        space.setBushes(createBushes());
        space.setLogs(createLog());
        space.setRiver(createRiver());
        space.setRiver(createRiver());
        space.setCars(createCar());
        space.setTrucks(createTruck());
        space.setEndLines(createEndLine());
        space.setCoins(createCoin());
        return space;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract Chicken createChicken();

    protected abstract List<Bush> createBushes();

    protected abstract List<River> createRiver();

    protected abstract List<Log> createLog();
  
    protected abstract List<Car> createCar();

    protected abstract List<Truck> createTruck();

    protected abstract List<EndLine> createEndLine();

    protected abstract List<Coin> createCoin();
}
