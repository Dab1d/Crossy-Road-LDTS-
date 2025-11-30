package CrossyRoad.state;

import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.view.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private T model;
    private Viewer<T> viewer;
    //falta adicionar o controller que ainda nao esta definido

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
    }

    public abstract Viewer<T> getViewer();

    //falta o getController

    public T getModel() {
        return model;
    }

    public void step(Game game, GUI gui) throws IOException {
        GUI.ACTION action = gui.getNextAction(); //detects user input
        //missing controller call to handle input
        viewer.draw(gui);
    }
}
