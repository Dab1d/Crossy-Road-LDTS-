package view;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.view.Viewer;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.*;

public class ViewerTest {

    @Test
    public void testViewerFullCycleAndBackground() throws IOException {
        GUI gui = mock(GUI.class);
        Object model = new Object();
        List<String> backgroundMap = List.of("a");

        Viewer<Object> viewer = new Viewer<Object>(model) {
            @Override
            protected void drawElements(GUI gui) {
                drawBackground(gui, backgroundMap);
                gui.drawText(new Position(0, 0), "test", "#FFFFFF", "#000000");
            }
        };
        viewer.draw(gui);

        verify(gui, times(1)).clear();
        verify(gui, times(1)).refresh();
        verify(gui).drawText(any(Position.class), eq("test"), anyString(), anyString());
        verify(gui, atLeastOnce()).drawPixel(eq(0.0), eq(0.0), anyString());    }

    @Test
    public void testGetModel() {
        Object model = new Object();
        Viewer<Object> viewer = new Viewer<>(model) {
            @Override
            protected void drawElements(GUI gui) {}
        };
        assert(viewer.getModel() == model);
    }
}