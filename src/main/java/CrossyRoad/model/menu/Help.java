package CrossyRoad.model.menu;

import java.util.List;

public class Help {

    private final List<String> lines;

    public Help() {
        this.lines = List.of(
                "Help Instructions:",
                "",
                "-> Use arrow keys",
                "   to move.",
                "",
                "-> Press Enter",
                "   to start.",
                "",
                "-> Press Q",
                "   to return."
        );
    }

    public List<String> getLines() {
        return lines;
    }
}
