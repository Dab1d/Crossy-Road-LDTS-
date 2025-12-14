package CrossyRoad.model.menu;

public class Score {
    private int points;

    public Score() { this.points = 0; }

    public int getPoints() { return points; }

    public void addPoints(int amount) { points += amount; }

    public void reset() { points = 0; }
}

