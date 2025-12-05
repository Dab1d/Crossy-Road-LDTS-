package CrossyRoad.Controler.Game;

import CrossyRoad.Controler.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.state.MenuState;

import java.io.IOException;

public class SpaceController extends Controller<Space> {

    private final ChickenController chickenController;
    private final CarController carController;
    private final RiverController riverController;
    private final TruckController truckController;

    public SpaceController(Space space) {
        super(space);
        this.chickenController = new ChickenController(space);
        this.carController = new CarController(space);
        this.riverController = new RiverController(space);
        this.truckController = new TruckController(space);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        // 1️⃣ Input do jogador
        switch(action) {
            case UP: case DOWN: case LEFT: case RIGHT:

                chickenController.step(game, action, time);
                break;
            case QUIT:
                game.setState(new MenuState(new Menu()));
                return;
            default:
                break;
        }

        // 2️⃣ Atualização automática
        carController.step(game, GUI.ACTION.NONE, time);
        truckController.step(game, GUI.ACTION.NONE, time);
        riverController.step(game, GUI.ACTION.NONE, time);

        // 3️⃣ Desenhar estado atual
        game.getGUI().clear();
        getModel().draw(game.getGUI());
        game.getGUI().refresh();
    }
}
