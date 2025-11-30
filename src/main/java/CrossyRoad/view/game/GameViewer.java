package CrossyRoad.view.game;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.game.elements.Element;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.view.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Space> {
    public GameViewer(Space space) {
        super(space);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui,getModel().getBushes(),new BushViewer());
        drawElements(gui, getModel().getCars(), new CarViewer());
        drawElements(gui, getModel().getLogs(), new LogViewer());
        drawElements(gui, getModel().getEndlines(), new EndLineViewer());
        drawElements(gui,getModel().getRiver(),new RiverViewer());
        drawElements(gui, getModel().getTruck(),new TruckViewer());
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElement(gui, getModel().getChicken(), new ChickenViewer());
    }

    protected <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    protected <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
