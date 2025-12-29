package CrossyRoad.Controller;

import CrossyRoad.state.StateManager;
import CrossyRoad.gui.GUI;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(StateManager game, GUI.ACTION action, long startTime) throws IOException;
}