package CrossyRoad.session;

public class GameSession {
    private int score;
    private int level;
    private static final int FINAL_LEVEL = 5;

    public GameSession() {
        resetLevel();
    }

    public void addScore() {
        this.score++;
    }

    public void resetScore() {
        this.score = 0;
    }

    public void resetLevel() {
        this.level = 1;
    }

    public void nextLevel() {
        if (!isMaxLevel()) {
            this.level++;
        }
    }

    public boolean isMaxLevel() {
        return this.level >= FINAL_LEVEL;
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }

    public void reset() {
        resetLevel();
        resetScore();
    }
}