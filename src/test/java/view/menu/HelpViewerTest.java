package view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.menu.Help;
import CrossyRoad.view.menu.HelpView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.mockito.Mockito.*;

public class HelpViewerTest {
    @Test
    public void testDrawElements() {
        GUI gui = Mockito.mock(GUI.class);
        Help model = Mockito.mock(Help.class);

        when(model.getNumberEntries()).thenReturn(1);
        when(model.getEntry(0)).thenReturn("Back");
        when(model.isSelected(0)).thenReturn(true);

        HelpView viewer = new HelpView(model);

        viewer.drawElements(gui);

        verify(gui).drawText(new Position(4, 1), "Crossy Road", "#F2BD97");
        verify(gui).drawText(new Position(3, 3), "Avoid cars and", "#C4C4C4");
        verify(gui).drawText(new Position(3, 4), "trucks while", "#C4C4C4");
        verify(gui).drawText(new Position(2, 5), "collecting coins", "#C4C4C4");
        verify(gui).drawText(new Position(2, 6), "Reach the end to", "#C4C4C4");
        verify(gui).drawText(new Position(2, 7), "save the chicken", "#C4C4C4");
        verify(gui).drawText(new Position(3, 14), " Instructions", "#F2BD97");
        verify(gui).drawText(new Position(3, 16), "Use arrow keys", "#C4C4C4");
        verify(gui).drawText(new Position(1, 17), "to move the chicken", "#C4C4C4");
        verify(gui).drawText(new Position(4, 25), "Back", "#F1E20E");
        verify(gui, times(10)).drawText(any(Position.class), anyString(), anyString());
    }
    @Test
    public void testDrawMultipleEntriesAndUnselectedColor() {
        GUI gui = mock(GUI.class);
        Help model = mock(Help.class);

        when(model.getNumberEntries()).thenReturn(2);
        when(model.getEntry(0)).thenReturn("Back");
        when(model.isSelected(0)).thenReturn(true);
        when(model.getEntry(1)).thenReturn("Reset");
        when(model.isSelected(1)).thenReturn(false);

        HelpView viewer = new HelpView(model);
        viewer.drawElements(gui);

        verify(gui, times(11)).drawText(any(Position.class), anyString(), anyString());
        verify(gui).drawText(eq(new Position(4, 25)), eq("Back"), eq("#F1E20E"));
        verify(gui).drawText(eq(new Position(10, 25)), eq("Reset"), eq("#C4C4C4"));
        verifyNoMoreInteractions(gui);
    }

    @Test
    public void testDrawZeroEntries() {
        GUI gui = mock(GUI.class);
        Help model = mock(Help.class);
        when(model.getNumberEntries()).thenReturn(0);
        HelpView viewer = new HelpView(model);

        viewer.drawElements(gui);
        verify(gui, times(9)).drawText(any(Position.class), anyString(), anyString());
        verify(gui, never()).drawText(argThat(p -> p != null && p.getY() == 25), anyString(), anyString());
        verifyNoMoreInteractions(gui);
    }
}