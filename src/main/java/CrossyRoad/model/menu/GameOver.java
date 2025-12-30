package CrossyRoad.model.menu;

import java.util.Arrays;
import java.util.List;

public class GameOver extends NavigableMenu {

    private List<String> background;

    public GameOver(List<String> background) {
        super(Arrays.asList("Restart", "Exit"));
        this.background = background;
    }

    public List<String> getBackground() {
        return background;
    }
}
