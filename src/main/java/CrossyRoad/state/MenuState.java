package CrossyRoad.state;

import CrossyRoad.Controler.Controller;
import CrossyRoad.Controler.Menu.MenuController;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.view.Viewer;
import CrossyRoad.view.menu.MenuView;


public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    public Viewer<Menu> getViewer() {
        return new MenuView(getModel());
    }

    @Override
    public Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}