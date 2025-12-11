package CrossyRoad;

import CrossyRoad.gui.GUI;
import CrossyRoad.gui.LanternaGUI;
import CrossyRoad.model.loader.Loader;
import CrossyRoad.state.MenuState;
import CrossyRoad.state.State;
import CrossyRoad.model.menu.Menu;


import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;
    private State previousState;
    private int level;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(20, 32);
        this.state = new MenuState(new Menu(new Loader("loadscreen").getLines()));
        this.level = 1;
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

    public State getState(){
        return this.state;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel(){
        return level;
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
