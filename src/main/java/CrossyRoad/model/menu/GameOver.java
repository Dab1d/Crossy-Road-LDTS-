package CrossyRoad.model.menu;

import java.util.Arrays;
import java.util.List;

public class GameOver {
    private final List<String> lines;
    private int currentEntry = 0;
    private List<String> background;

    public GameOver(List<String> background, Score score) {
        this.background = background;
        this.lines = Arrays.asList("Restart", "Exit");
    }
    public GameOver() {
        this.lines = Arrays.asList("Restart", "Exit");
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.lines.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.lines.size() - 1;
    }

    public String getEntry(int i) {
        return lines.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

    public boolean isSelectedRestart() {
        return isSelected(0);
    }

    public List<String> getLines() {
        return lines;
    }

    public int getNumberEntries() {
        return this.lines.size();
    }

    public List<String> getBackground() {
        return background;
    }

}
