package view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.menu.GameOver;
import CrossyRoad.view.menu.GameOverView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class GameOverViewerTest {
    @Test
    public void drawElementsTest() {
        GUI gui = Mockito.mock(GUI.class);
        GameOver model = Mockito.mock(GameOver.class);

        List<String> backgroundSimulado = Arrays.asList("a");
        when(model.getBackground()).thenReturn(backgroundSimulado);
        when(model.getNumberEntries()).thenReturn(2);
        when(model.getEntry(0)).thenReturn("Restart");
        when(model.isSelected(0)).thenReturn(true);
        when(model.getEntry(1)).thenReturn("Exit");
        when(model.isSelected(1)).thenReturn(false);

        GameOverView viewer = new GameOverView(model);

        viewer.drawElements(gui);

        verify(gui).drawPixel(0.0, 0.0, "#000000");
        verify(gui).drawText(new Position(2, 11), "Restart", "#F1E20E");
        verify(gui).drawText(new Position(12, 11), "Exit", "#C4C4C4");
        verifyNoMoreInteractions(gui);
    }
    @Test
    public void testUnknownCharacterInMap() {

        GUI gui = Mockito.mock(GUI.class);
        GameOver model = Mockito.mock(GameOver.class);

        //char z that doesn't belong to doc
        when(model.getBackground()).thenReturn(Arrays.asList("z"));

        GameOverView viewer = new GameOverView(model);
        viewer.drawElements(gui);

        // should be default color #FFFFFF
        verify(gui).drawPixel(0, 0, "#FFFFFF");
    }
    @Test
    public void testNullBackground() {

        GUI gui = Mockito.mock(GUI.class);
        GameOver model = Mockito.mock(GameOver.class);


        when(model.getBackground()).thenReturn(null);

        when(model.getNumberEntries()).thenReturn(1);
        when(model.getEntry(0)).thenReturn("Restart");
        when(model.isSelected(0)).thenReturn(true);

        GameOverView viewer = new GameOverView(model);
        viewer.drawElements(gui);

        // Check if any pixel was drawn
        verify(gui, never()).drawPixel(anyInt(), anyInt(), anyString());

        //Check if text was drawn (should be drawn)
        verify(gui).drawText(
                new Position(2, 11),
                "Restart",
                "#F1E20E"
        );
    }
    @Test
    public void testDrawElementsWithZeroEntries() {
        GUI gui = Mockito.mock(GUI.class);
        GameOver model = Mockito.mock(GameOver.class);

        when(model.getNumberEntries()).thenReturn(0);
        when(model.getBackground()).thenReturn(Collections.emptyList());

        GameOverView viewer = new GameOverView(model);

        viewer.drawElements(gui);
        verify(gui, never()).drawText(any(), anyString(), anyString());
    }

}