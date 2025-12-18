package CrossyRoad.state;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Controller.Menu.MenuController;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.model.loader.Loader;
import CrossyRoad.view.Viewer;
import CrossyRoad.view.menu.MenuView;

import java.io.IOException;

public class MenuState extends State<Menu> {

    // Construtor que lê o loadscreen do TXT
    public MenuState() throws IOException {
        super(new Menu(new Loader("loadscreen").getLines()));
    }

    // Construtor que recebe um Menu já criado
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
