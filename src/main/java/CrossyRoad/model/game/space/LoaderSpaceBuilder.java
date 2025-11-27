package CrossyRoad.model.game.space;



import CrossyRoad.model.game.elements.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderSpaceBuilder extends SpaceBuilder{
    private final int level;
    private final List<String> lines;

    public LoaderSpaceBuilder(int level) throws IOException {
        this.level = level;

        URL resource = LoaderSpaceBuilder.class.getResource("/levels/lvl" + level + ".lvl");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') walls.add(new Wall(x, y));
        }

        return walls;
    }

    @Override
    protected Chicken createChicken() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                if (line.charAt(x) == 'C') {
                    return new Chicken(x, y);
                }
            }
        }
        throw new IllegalStateException("No chicken found in level " + level);
    }

    @Override
    protected List<Bush> createBushes() {
        List<Bush> bushes = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                if (line.charAt(x) == '@') bushes.add(new Bush(x, y));
            }
        }
        return bushes;
    }


    @Override
    protected List<River> createRiver() {
        List<River> river = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                if (line.charAt(x) == '-') river.add(new River(x, y));
            }
        }
        return river;
    }

    @Override
    protected List<Car> createCar() {
        List<Car> car = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                if (line.charAt(x) == 'Ç') car.add(new Car(x, y));
            }
        }
        return car;
    }

    @Override
    protected List<Truck> createTruck() {
        List<Truck> trucks = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                if (line.charAt(x) == 'Y') trucks.add(new Truck(x, y));
            }
        }
        return trucks;
    }

}
