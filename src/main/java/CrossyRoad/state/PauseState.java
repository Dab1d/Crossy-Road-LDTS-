package CrossyRoad.state;

import CrossyRoad.controller.Controller;
import CrossyRoad.model.menu.Pause;
import CrossyRoad.view.Viewer;

public class PauseState extends State<Pause> {
    private final Controller<Pause> controller;
    private final Viewer<Pause> viewer;

    public PauseState(Pause model, Controller<Pause> controller, Viewer<Pause> viewer) {
        super(model);
        this.controller = controller;
        this.viewer = viewer;
    }

    @Override
    public Viewer<Pause> getViewer() {
        return viewer;
    }

    @Override
    public Controller<Pause> getController() {
        return controller;
    }
}