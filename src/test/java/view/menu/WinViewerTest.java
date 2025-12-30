package view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.menu.Win;
import CrossyRoad.view.menu.WinViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class WinViewerTest {

    @Test
    public void testDrawBackgroundAndEntries() {
        GUI gui = Mockito.mock(GUI.class);
        Win model = Mockito.mock(Win.class);

        // 'a' -> black(#000000) , 'd' -> red(#FF0000)
        List<String> mockBackground = Arrays.asList("ad");
        when(model.getBackground()).thenReturn(mockBackground);

        // Menu e Exit
        when(model.getNumberEntries()).thenReturn(2);

        // Menu Selected
        when(model.getEntry(0)).thenReturn("Menu");
        when(model.isSelected(0)).thenReturn(true);

        // Exit not selected
        when(model.getEntry(1)).thenReturn("Exit");
        when(model.isSelected(1)).thenReturn(false);

        WinViewer viewer = new WinViewer(model);
        viewer.drawElements(gui);


        verify(gui).drawPixel(0, 0, "#000000"); // 'a'
        verify(gui).drawPixel(1, 0, "#FF0000"); // 'd'
        verify(gui).drawText(
                new Position(2, 9),
                "Menu",
                "#F1E20E"
        );
        verify(gui).drawText(
                new Position(12, 9),
                "Exit",
                "#C4C4C4"
        );
    }

    @Test
    public void testUnknownCharacterInMap() {
        GUI gui = Mockito.mock(GUI.class);
        Win model = Mockito.mock(Win.class);

        when(model.getBackground()).thenReturn(Arrays.asList("z"));

        WinViewer viewer = new WinViewer(model);
        viewer.drawElements(gui);

        verify(gui).drawPixel(0, 0, "#FFFFFF");
    }

    @Test
    public void testNullBackground() {
        GUI gui = Mockito.mock(GUI.class);
        Win model = Mockito.mock(Win.class);

        when(model.getBackground()).thenReturn(null);

        //ensure that buttons still work
        when(model.getNumberEntries()).thenReturn(1);
        when(model.getEntry(0)).thenReturn("Exit");
        when(model.isSelected(0)).thenReturn(true);

        WinViewer viewer = new WinViewer(model);
        viewer.drawElements(gui);

        //checks that none pixel was drawn
        verify(gui, never()).drawPixel(anyInt(), anyInt(), anyString());

        //check if text still drawn
        verify(gui).drawText(
                new Position(2, 9),
                "Exit",
                "#F1E20E"
        );
    }
    @Test
    void testDrawElementsCountStrict() {
        GUI gui = mock(GUI.class);
        Win model = mock(Win.class);

        when(model.getNumberEntries()).thenReturn(2);
        when(model.getEntry(0)).thenReturn("Play Again");
        when(model.isSelected(0)).thenReturn(true);
        when(model.getEntry(1)).thenReturn("Menu");
        when(model.isSelected(1)).thenReturn(false);
        when(model.getBackground()).thenReturn(Collections.emptyList());

        WinViewer viewer = new WinViewer(model);

        viewer.drawElements(gui);

        verify(gui).drawText(eq(new Position(2, 9)), eq("Play Again"), eq("#F1E20E"));
        verify(gui).drawText(eq(new Position(12, 9)), eq("Menu"), eq("#C4C4C4"));
        verify(gui, times(2)).drawText(any(Position.class), anyString(), anyString());
        verifyNoMoreInteractions(gui);
    }
}