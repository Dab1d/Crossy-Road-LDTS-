package CrossyRoad.model.menu;

import java.util.Arrays;
import java.util.List;

public class Win {
    private final List<String> lines;
    private int currentEntry = 0;
    private final List<String> background;

    public Win(List<String> background) {
        this.background = background;
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

    public int getCurrentEntry() { return currentEntry; }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public int getNumberEntries() {
        return this.lines.size();
    }

    public List<String> getBackground() {
        return background;
    }

}
