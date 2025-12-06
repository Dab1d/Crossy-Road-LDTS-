package CrossyRoad.model.menu;

import java.util.List;

public class GameOver {
    private final List<String> lines;

    public GameOver(Score score) {
        this.lines = List.of(
                "  GAME OVER",
                "",
                "Final Score: " + score.getPoints(),
                "",
                "-> Press Q",
                "   to return"
        );
    }

    public List<String> getLines() {
        return lines;
    }
}
