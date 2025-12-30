package CrossyRoad.state;

import CrossyRoad.controller.Controller;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.view.Viewer;


public class MenuState extends State<Menu> {
    private final Controller<Menu> controller;
    private final Viewer<Menu> viewer;

    // Construtor que lê o loadscreen do TXT
    public MenuState(Menu model, Controller<Menu> controller, Viewer<Menu> viewer) {
        super(model);
        this.controller = controller;
        this.viewer = viewer;
    }

    @Override
    public Viewer<Menu> getViewer() {
        return viewer;
    }

    @Override
    public Controller<Menu> getController() {
        return controller;
    }
}
