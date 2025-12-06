package CrossyRoad.model.game.space;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.*;
import CrossyRoad.model.Position;

import java.util.ArrayList;
import java.util.List;

public class Space {

    private final int width;
    private final int height;

    private Chicken chicken;

    private List<Bush> bushes;
    private List<Truck> trucks;
    private List<Car> cars;
    private List<River> river;
    private List<Log> logs;
    private List<EndLine> endlines;
    private List<Wall> walls;

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public List<Element> getAllElements() {
        List<Element> all = new ArrayList<>();

        all.add(chicken);
        all.addAll(walls);
        all.addAll(bushes);
        all.addAll(cars);
        all.addAll(trucks);
        all.addAll(river);
        all.addAll(logs);
        all.addAll(endlines);

        return all;
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

    public void setChicken(Chicken chicken) {
        this.chicken = chicken;
    }

    public List<Bush> getBushes() {
        return bushes;
    }

    public void setBushes(List<Bush> bushes) {
        this.bushes = bushes;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Truck> getTruck() {
        return trucks;
    }

    public void setTrucks(List<Truck> trucks) {
        this.trucks = trucks;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setRiver(List<River> river) {
        this.river = river;
    }

    public List<River> getRiver() {
        return river;
    }

    public void setEndLines(List<EndLine> endlines) {
        this.endlines = endlines;
    }

    public List<EndLine> getEndlines() {
        return endlines;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public boolean isEmpty(Position pos) {
        for (Element e : getAllElements())
            if (e.blockMovement() && e.getPosition().equals(pos))
                return false;

        return true;
    }

    public boolean isChickenDead() {
        Position pos = chicken.getPosition();

        for (Car car : cars) {
            if (pos.equals(car.getPosition())) return true;
        }

        for (Truck truck : trucks) {
            if (pos.equals(truck.getPosition())) return true;
        }

        for (River r : river) {
            if (pos.equals(r.getPosition())) {
                return true;
            }
        }
        return false;
    }

    public int[] getRiverLinesY() {
        int[] lines = new int[river.size()];

        for (int i = 0; i < river.size(); i++) {
            lines[i] = river.get(i).getPosition().getY();
        }

        return lines;
    }

    public List<Position> getRiverPositionsAtLine(int y) {
        List<Position> positions = new ArrayList<>();

        for (River r : river) {
            if (r.getPosition().getY() == y) {
                positions.add(r.getPosition());
            }
        }
        return positions;
    }

    public boolean reachedEndLine() {
        Position chickenPos = chicken.getPosition();
        for (EndLine endline : endlines) {
            if (chickenPos.equals(endline.getPosition())) return true;
        }
        return false;
    }
}
