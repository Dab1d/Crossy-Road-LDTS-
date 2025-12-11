package CrossyRoad.model.menu;

import java.util.Arrays;
import java.util.List;

public class Pause {
    private final List<String> entries;
    private int currentEntry = 0;

    public Pause() {
        this.entries = Arrays.asList("Resume", "Menu", "Quit");
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedQuit() {
        return isSelected(2);
    }

    public boolean isSelectedMenu() {return isSelected(1);}

    public boolean isSelectedResume() {
        return isSelected(0);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
