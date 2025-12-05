package CrossyRoad.model.menu;

import java.util.List;

public class EndLine {
    private final List<String> lines;

    public EndLine() {
        this.lines = List.of(
                "CONGRATULATIONS",
                "",
                "YOU WON",
                "",
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
