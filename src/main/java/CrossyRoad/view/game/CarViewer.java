package CrossyRoad.view.game;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.Car;

public class CarViewer implements ElementViewer<Car>{
    @Override
    public void draw(Car car, GUI gui) {
        gui.drawCharacter(car.getPosition().getX(), car.getPosition().getY(), 'C', "#C4A480");
    }
}
