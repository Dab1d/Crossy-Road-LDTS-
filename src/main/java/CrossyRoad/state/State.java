package CrossyRoad.state;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.view.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private T model;
    private Viewer<T> viewer;
    private Controller<T> controller;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    // for mock testing
    public State(T model, Viewer<T> viewer, Controller<T> controller) {
        this.model = model;
        this.viewer = viewer;
        this.controller = controller;
    }

    public abstract Viewer<T> getViewer();

    public abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(Game game, GUI gui, long startTime) throws IOException {
        GUI.ACTION action = gui.getNextAction(); //detects user input
        controller.step(game, action, startTime);
        viewer.draw(gui);
    }
}
