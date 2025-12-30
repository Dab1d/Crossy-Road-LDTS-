package CrossyRoad.state;

import CrossyRoad.session.GameSession;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class StateManager {
    private final StateFactory stateFactory;
    private final GameSession gameSession;

    private State state;
    private State previousState;

    /**
     * Primary constructor that allows Dependency Injection.
     * For testing (injecting mocks) or loading saved games.
     */
    public StateManager(StateFactory stateFactory, GameSession gameSession) throws IOException, URISyntaxException, FontFormatException {
        this.stateFactory = stateFactory;
        this.gameSession = gameSession;
        this.state = stateFactory.createMenuState();
    }
    /**
     * Convenience constructor for the main game loop.
     * It initializes a default GameSession and delegates to the primary constructor.
     */

    public StateManager(StateFactory stateFactory) throws IOException, URISyntaxException, FontFormatException {
        this(stateFactory, new GameSession());
    }
    public void initGame() throws IOException {
        gameSession.resetScore();
        gameSession.resetLevel();
        this.setState(stateFactory.createGameState(gameSession.getLevel()));
    }

    public void returnToMenu() throws IOException {
        gameSession.resetLevel();
        gameSession.resetScore();
        setState(stateFactory.createMenuState());
    }

    public void pauseGame() throws IOException {
        setPrevious(state);
        setState(stateFactory.createPauseState());
    }

    public void resumeGame() {
        if (previousState != null) {
            setState(this.getPrevious());
        }
    }

    public void winGame() throws IOException {
        setState(stateFactory.createWinState());
    }

    public void loseGame() throws IOException {
//        gameSession.resetLevel();
//        gameSession.resetScore();
        setState(stateFactory.createGameOverState());
    }

    public void advanceLevel() throws IOException {
        if (!gameSession.isMaxLevel()) {
            gameSession.nextLevel();
            this.setState(stateFactory.createGameState(gameSession.getLevel()));
        } else {
            this.finishGame();
        }
    }

    public void finishGame() throws IOException {
        winGame();
    }

    public void goToHelp() throws IOException {
        setState(stateFactory.createHelpState());
    }

    public void quitGame() {
        this.setState(null);
    }

    // Setters and Getters
    public void setState(State state) { this.state = state; }
    public State getState() { return this.state; }
    public void setPrevious(State state) { this.previousState = state; }
    public State getPrevious() { return this.previousState; }
    public GameSession getGameSession() {return this.gameSession;}
}