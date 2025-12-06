package CrossyRoad.state;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Controller.Menu.MenuController;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.model.menu.MenuLoader;
import CrossyRoad.view.Viewer;
import CrossyRoad.view.menu.MenuView;

import java.io.IOException;

public class MenuState extends State<Menu> {

    // Construtor que lê o loadscreen do TXT
    public MenuState() throws IOException {
        super(new Menu(MenuLoader.loadBackground()));
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
