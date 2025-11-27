package CrossyRoad.model.game.space;

import CrossyRoad.model.game.elements.*;
import CrossyRoad.model.Position;

import java.util.List;

public class Space {

    private final int width;
    private final int height;

    private Chicken chicken;
    private List<Bush> bushes;
    private List<Wall> walls;
    private List<River> river;

    private List<Truck> trucks;
    private List<Car> cars;

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Chicken getChicken() {
        return chicken;
    }

    public void setChicken(Chicken chicken) { this.chicken = chicken;}

    public List<Bush> getBushes() { return bushes;}

    public void setBushes(List<Bush> bush){this.bushes = bush;}

    public List<River> getRiver() {return river;}

    public void setRiver(List<River> river) {this.river = river;}

    public List<Car> getCars() {return cars;}

    public void setCars(List<Car> cars){this.cars = cars;}

    public void setTrucks(List<Truck> trucks) {this.trucks = trucks;}

    public List<Truck> getTrucks() {return trucks;}

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }
}
