package CrossyRoad.state;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class StateManager {
    private final StateFactory stateFactory;
    private State state;
    private State previousState;
    private int level;
    private int score;
    private static final int FINAL_LEVEL = 5;


    public StateManager(StateFactory stateFactory) throws IOException, URISyntaxException, FontFormatException {
        this.stateFactory = stateFactory;
        this.level = 1;
        this.score = 0;
        this.state = stateFactory.createMenuState();
    }

    public void initGame() throws IOException {
        this.score = 0;
        this.level = 1;
        this.setState(stateFactory.createGameState(this.level));
    }

    public void quitGame() {
        this.setState(null);
    }

    public void pauseGame() {
        this.previousState = this.state;
        this.setState(stateFactory.createPauseState());
    }

    public void resumeGame() {
        this.setState(this.getPrevious());
    }

    public void returnToMenu() throws IOException {
        this.level = 1;
        this.score = 0;
        this.setState(stateFactory.createMenuState());
    }

    public void goToHelp() throws IOException {
        this.setState(stateFactory.createHelpState());
    }

    public void winGame() throws IOException {
        this.setState(stateFactory.createWinState());
    }

    public void advanceLevel() throws IOException {
        if(this.level < FINAL_LEVEL) {
            this.level++;
            this.setState(stateFactory.createGameState(this.level));
        } else {
            this.finishGame();
        }
    }

    public void finishGame() throws IOException {
        winGame();
    }

    public void loseGame() throws IOException {
        this.level = 1;
        this.score = 0;
        this.setState(stateFactory.createGameOverState());
    }


    public void setState(State state) { this.state = state; }
    public State getState() { return this.state; }
    public void setPrevious(State state) { this.previousState = state; }
    public State getPrevious() { return this.previousState; }
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
    public int getScore() { return score; }
    public void addScore() { score++; }
    public void resetScore() { this.score = 0; }
}