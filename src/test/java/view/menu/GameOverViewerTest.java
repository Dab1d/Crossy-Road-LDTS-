package view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.menu.GameOver;
import CrossyRoad.view.menu.GameOverView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class GameOverViewerTest {

    @Test
    public void drawElementsTest() {

        GUI gui = Mockito.mock(GUI.class);
        GameOver model = Mockito.mock(GameOver.class);
        List<String> backgroundSimulado = Arrays.asList("ad");
        when(model.getBackground()).thenReturn(backgroundSimulado);
        when(model.getNumberEntries()).thenReturn(2);

        //Reset Select
        when(model.getEntry(0)).thenReturn("Restart");
        when(model.isSelected(0)).thenReturn(true);

        // Exit not selected
        when(model.getEntry(1)).thenReturn("Exit");
        when(model.isSelected(1)).thenReturn(false);


        GameOverView viewer = new GameOverView(model);
        viewer.drawElements(gui);

        // char 'a' has to be painted as black and 'd' as red
        verify(gui, times(1)).drawPixel(0, 0, "#000000");
        verify(gui, times(1)).drawPixel(1, 0, "#FF0000");

        // Check restart
        verify(gui, times(1)).drawText(
                new Position(2, 11),
                "Restart",
                "#F1E20E"
        );

        // Check exit
        verify(gui, times(1)).drawText(
                new Position(12, 11),
                "Exit",
                "#C4C4C4"
        );
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
}