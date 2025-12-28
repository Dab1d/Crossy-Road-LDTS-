package CrossyRoad;

import CrossyRoad.gui.GUI;
import CrossyRoad.gui.LanternaGUI;
import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.loader.Loader;
import CrossyRoad.model.loader.ScreenType;
import CrossyRoad.model.menu.Help;
import CrossyRoad.model.menu.Pause;
import CrossyRoad.model.menu.Win;
import CrossyRoad.state.*;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.view.menu.HUDView;


import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;
    private State previousState;
    private int level;
    private int score;
    private HUDView hud;
    private static final int FINAL_LEVEL = 5;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(20, 32);
        this.state = new MenuState(
                new Menu(
                        new Loader(ScreenType.MENU.getFile()).getLines()
                )
        );

        this.level = 1;
        this.score = 0;
        this.hud = new HUDView();
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        new Game().start();
    }

    public void setPrevious(State state) {
        this.previousState = state;
    }

    public State getPrevious() {
        return this.previousState;
    }

    public State getState() {
        return this.state;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void addScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public HUDView getHUD() {
        return hud;
    }

    public void resetScore() {
        this.score = 0;
    }

    public void initGame() throws IOException {
        this.score = 0;
        this.level = 1;
        this.setState(new GameState(new LoaderSpaceBuilder(this.getLevel()).createSpace()));
    }

    public void quitGame() {
        this.setState(null);
    }

    public void pauseGame() {
        this.previousState = this.state;
        this.setState(new PauseState(new Pause()));
    }

    public void resumeGame() {
        this.setState(this.getPrevious());
    }

    public void returnToMenu() throws IOException {
        this.level = 1;
        this.score = 0;
        this.setState(new MenuState(new Menu(new Loader("loadscreen").getLines())));
    }

    public void goToHelp() {
        this.setState(new HelpState(new Help()));
    }

    public void winGame() throws IOException {
        Loader loader = new Loader(ScreenType.WIN.getFile());
        Win winMenu = new Win(loader.getLines());
        this.setState(new WinState(winMenu));
    }


    public void advanceLevel() throws IOException {
        if(this.level < FINAL_LEVEL) {
            this.level++;
            this.setState(new GameState(new LoaderSpaceBuilder(this.getLevel()).createSpace()));
        } else {
            this.finishGame();
        }
    }

    public void finishGame() throws IOException {
        Loader loader = new Loader(ScreenType.WIN.getFile());
        Win winMenu = new Win(loader.getLines());
        this.setState(new WinState(winMenu));
    }

    //will be used by the controller to chance between menu and game state
    public void setState(State state) {
        this.state = state;
    }

    public void start() throws IOException {
        int FPS = 60;
        int frameTime = 1000 / FPS;
        while (state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);
            hud.draw(gui, this.getScore(),this.getLevel());

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;
            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gui.close();
    }

    public GUI getGUI() {
        return gui;
    }
}
