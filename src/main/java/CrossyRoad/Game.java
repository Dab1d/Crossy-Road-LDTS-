package CrossyRoad;

import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.loader.Loader;
import CrossyRoad.model.loader.ScreenType;
import CrossyRoad.model.menu.*;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.state.*;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private State state;
    private State previousState;
    private int level;
    private int score;
    private static final int FINAL_LEVEL = 5;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        // Inicializa apenas o estado inicial (Menu)
        this.state = new MenuState(
                new Menu(new Loader(ScreenType.MENU.getFile()).getLines())
        );
        this.level = 1;
        this.score = 0;
    }

    // --- Gestão de Estado ---
    public void setState(State state) { this.state = state; }
    public State getState() { return this.state; }

    public void setPrevious(State state) { this.previousState = state; }
    public State getPrevious() { return this.previousState; }

    // --- Dados do Jogo ---
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public int getScore() { return score; }
    public void addScore() { score++; }
    public void resetScore() { this.score = 0; }

    // --- Lógica de Transição (Regras de Negócio) ---
    public void initGame() throws IOException {
        this.score = 0;
        this.level = 1;
        this.setState(new GameState(new LoaderSpaceBuilder(this.getLevel()).createSpace()));
    }

    public void quitGame() {
        this.setState(null); // Isto vai parar o loop no Controller
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
        winGame(); // Reutiliza a lógica
    }

    public void loseGame() throws IOException {
        this.level = 1;
        this.score = 0;
        Loader loader = new Loader(ScreenType.LOSE.getFile());
        GameOver gameOver = new GameOver(loader.getLines());
        this.setState(new GameOverState(gameOver));
    }
}