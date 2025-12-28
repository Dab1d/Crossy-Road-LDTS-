package CrossyRoad.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> entries;
    private int currentEntry = 0;
    private List<String> background;
    private final String backgroundColor = "#b914c8";

    public Menu(List<String> background) {
        this.background = background;
        this.entries = Arrays.asList("Start", "Help", "Exit");
    }

    public Menu() {
        this.entries = Arrays.asList("Start", "Help", "Exit");
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

    public int getCurrentEntry() { return currentEntry; }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    public List<String> getBackground() {
        return background;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }
}