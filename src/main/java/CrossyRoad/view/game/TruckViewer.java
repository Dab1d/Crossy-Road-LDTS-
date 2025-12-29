package CrossyRoad.view.game;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.Truck;

public class TruckViewer implements ElementViewer<Truck> {
    @Override
    public void draw(Truck truck, GUI gui) {
        gui.drawPixel(truck.getPosition().getX(), truck.getPosition().getY(), "#A19E67");
        }
}
