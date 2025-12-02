package CrossyRoad.state;

import CrossyRoad.Controler.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.view.Viewer;

public class HelpState extends State<Void> {
    public HelpState() {
        super(null); // no model needed
    }

    @Override
    public Viewer<Void> getViewer() {
        return new Viewer<Void>(null) {
            @Override
            public void drawElements(GUI gui) {
                gui.drawText(new Position(0, 0), "Help Instructions:", "#FFF888");
                gui.drawText(new Position(0, 2), "-> Use arrow", "#FFFFFF");
                gui.drawText(new Position(0, 3), "   keys to move.", "#FFFFFF");
                gui.drawText(new Position(0, 5), "-> Press Enter", "#FFFFFF");
                gui.drawText(new Position(0, 6), "   to start.", "#FFFFFF");
                gui.drawText(new Position(0, 8), "-> Press Q", "#FFFFFF");
                gui.drawText(new Position(0, 9), "   to return.", "#FFFFFF");

            }
        };
    }

    @Override
    public Controller<Void> getController() {
        return new Controller<Void>(null) {
            @Override
            public void step(Game game, GUI.ACTION action, long time) {
                switch (action) {
                    case QUIT:
                        game.setState(new MenuState(new CrossyRoad.model.menu.Menu()));
                        break;
                }
            }
        };
    }
}
