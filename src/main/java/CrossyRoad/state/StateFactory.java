package CrossyRoad.state;

import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.loader.Loader;
import CrossyRoad.model.loader.ScreenType;
import CrossyRoad.model.menu.*;

import java.io.IOException;

public class StateFactory  {

    public State createMenuState() throws IOException {
        return new MenuState(new Menu(new Loader(ScreenType.MENU.getFile()).getLines()));
    }

    public State createGameState(int level) throws IOException {
        return new GameState(new LoaderSpaceBuilder(level).createSpace());
    }


    public State createPauseState() {
        return new PauseState(new Pause());
    }


    public State createHelpState(){
        return new HelpState(new Help());}

    public State createWinState() throws IOException {
        Loader loader = new Loader(ScreenType.WIN.getFile());
        return new WinState(new Win(loader.getLines()));
    }

    public State createGameOverState() throws IOException {
        Loader loader = new Loader(ScreenType.LOSE.getFile());
        return new GameOverState(new GameOver(loader.getLines()));
    }
}