package CrossyRoad.state;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Controller.Menu.MenuController;
import CrossyRoad.Controller.Menu.PauseController;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.model.menu.Pause;
import CrossyRoad.view.Viewer;
import CrossyRoad.view.menu.MenuView;
import CrossyRoad.view.menu.PauseViewer;

public class PauseState extends State<Pause> {
    public PauseState(Pause model) {
        super(model);
    }

    @Override
    public Viewer<Pause> getViewer() {
        return new PauseViewer(getModel());
    }

    @Override
    public Controller<Pause> getController() {
        return new PauseController(getModel());
    }
}