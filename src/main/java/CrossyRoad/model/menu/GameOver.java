package CrossyRoad.model.menu;

import java.util.List;

public class GameOver {
    private final List<String> lines;

    public GameOver() {
        this.lines = List.of(
                "  GAME OVER",
                "",
                "",
                "-> Press Q",
                "   to return"
        );
    }

    public List<String> getLines() {
        return lines;
    }
}
