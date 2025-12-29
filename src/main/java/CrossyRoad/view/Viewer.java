package CrossyRoad.view;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.loader.ColorAdapter;

import java.io.IOException;
import java.util.List;

public abstract class Viewer<T> {
    private final T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

    protected abstract void drawElements(GUI gui);

    protected void drawBackground(GUI gui, List<String> background) {
        if (background == null) return;

        for (int y = 0; y < background.size(); y++) {
            String line = background.get(y);
            for (int x = 0; x < line.length(); x++) {
                char c = line.charAt(x);
                String color = ColorAdapter.getHexColor(c);
                gui.drawPixel(x, y, color);
            }
        }
    }
}