package CrossyRoad.model.game.space;

import CrossyRoad.model.Position;
import CrossyRoad.model.game.elements.Chicken;
import CrossyRoad.model.game.elements.Wall;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class loadSpaceBuilder extends SpaceBuilder {
   @Override
    protected int getWidth(){
       return 20;
   }

   protected int getHeight(){
       return 20;
   }


    @Override
    protected Chicken createChicken() {
        return new Chicken(10, 10);
    }

    @Override
    protected List<Wall> createWalls() {
       List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < getHeight(); c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, getWidth()-1));
        }
        for (int c = 0; c < getWidth(); c++) {
            walls.add(new Wall(0, c));
            walls.add(new Wall(getHeight() - 1, c));
        };
        return walls;
    }
}

