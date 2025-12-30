package CrossyRoad.state;

import CrossyRoad.controller.Controller;
import CrossyRoad.model.menu.Help;
import CrossyRoad.view.Viewer;

public class HelpState extends State<Help> {
    private final Controller<Help> controller;
    private final Viewer<Help> viewer;

    public HelpState(Help model, Controller<Help> controller, Viewer<Help> viewer) {
        super(model);
        this.controller = controller;
        this.viewer = viewer;
    }

    @Override
    public Viewer<Help> getViewer() {
        return viewer;
    }

    @Override
    public Controller<Help> getController() {
        return controller;
    }
}
