package CrossyRoad.state;

import CrossyRoad.controller.Game.SpaceController;
import CrossyRoad.controller.Menu.*;
import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.model.loader.Loader;
import CrossyRoad.model.loader.ScreenType;
import CrossyRoad.model.menu.*;
import CrossyRoad.view.GameViewer;
import CrossyRoad.view.menu.*;

import java.io.IOException;

public class GeneralStateFactory implements StateFactory {

    @Override
    public State createMenuState() throws IOException {
        Loader loader = new Loader(ScreenType.MENU.getFile());
        Menu model = new Menu(loader.getLines());
        MenuController controller = new MenuController(model);
        MenuView viewer = new MenuView(model);
        return new MenuState(model, controller, viewer);
    }

    @Override
    public State createGameState(int level) throws IOException {
        Space space = new LoaderSpaceBuilder(level).createSpace();
        SpaceController controller = new SpaceController(space);
        GameViewer viewer = new GameViewer(space);
        return new GameState(space, controller, viewer);
    }

    @Override
    public State createPauseState() {
        Pause model = new Pause();
        PauseController controller = new PauseController(model);
        PauseViewer viewer = new PauseViewer(model);
        return new PauseState(model, controller, viewer);
    }

    @Override
    public State createWinState() throws IOException {
        Loader loader = new Loader(ScreenType.WIN.getFile());
        Win model = new Win(loader.getLines());
        WinController controller = new WinController(model);
        WinViewer viewer = new WinViewer(model);
        return new WinState(model, controller, viewer);
    }

    @Override
    public State createGameOverState() throws IOException {
        Loader loader = new Loader(ScreenType.LOSE.getFile());
        GameOver model = new GameOver(loader.getLines());
        GameOverController controller = new GameOverController(model);
        GameOverView viewer = new GameOverView(model);
        return new GameOverState(model, controller, viewer);
    }

    @Override
    public State createHelpState() {
        Help model = new Help();
        HelpController controller = new HelpController(model);
        HelpView viewer = new HelpView(model);
        return new HelpState(model, controller, viewer);
    }
}