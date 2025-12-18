package CrossyRoad.model.menu;

import java.util.Arrays;
import java.util.List;

public class Help {

    private final List<String> lines;
    private int currentEntry = 0;

    public Help() {
        this.lines = Arrays.asList("Start", "Return");
    }

    public List<String> getLines() {
        return lines;
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

    public boolean isSelectedReturn() {
        return isSelected(1);
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public int getNumberEntries() {
        return this.lines.size();
    }
}
