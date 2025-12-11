package CrossyRoad.view.game;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.Car;

public class CarViewer implements ElementViewer<Car>{
    @Override
    public void draw(Car car, GUI gui) {
        gui.drawPixel(car.getPosition().getX(), car.getPosition().getY(), "#540D00");
    }
}
