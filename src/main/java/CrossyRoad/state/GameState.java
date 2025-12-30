package CrossyRoad.state;

import CrossyRoad.controller.Controller;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.session.GameSession;
import CrossyRoad.view.Viewer;
import CrossyRoad.view.game.GameViewer;
import CrossyRoad.view.menu.HUDView;

import java.io.IOException;

public class    GameState extends State<Space> {
    private final Controller<Space> controller;
    private final Viewer<Space> viewer;
    private final HUDView hudView;


    public GameState(Space space, Controller<Space> controller, Viewer<Space> viewer, HUDView hudView) {
        super(space, new GameViewer(space), controller);
        this.controller = controller;
        this.viewer = viewer;
        this.hudView = hudView;
    }
    public GameState(Space space, Controller<Space> controller, Viewer<Space> viewer) {
        this(space, controller, viewer, new HUDView());
    }

    @Override
    public Viewer<Space> getViewer() {
        return viewer;
    }

    @Override
    public Controller<Space> getController() {
        return controller;
    }
    @Override
    public void step(StateManager stateManager, GUI gui, long time) throws IOException {
        GUI.ACTION action = gui.getNextAction();
        getController().step(stateManager, action, time);
        getViewer().draw(gui);
        GameSession session = stateManager.getGameSession();
        hudView.draw(gui, session.getScore(), session.getLevel());
    }
}

