package view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.menu.Pause;
import CrossyRoad.view.menu.PauseViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class PauseViewerTest {
    @Test
    public void testDrawElements() {
        GUI gui = Mockito.mock(GUI.class);
        Pause model = Mockito.mock(Pause.class);

        when(model.getNumberEntries()).thenReturn(2);
        when(model.getEntry(0)).thenReturn("Resume");
        when(model.isSelected(0)).thenReturn(true);
        when(model.getEntry(1)).thenReturn("Menu");
        when(model.isSelected(1)).thenReturn(false);

        PauseViewer viewer = new PauseViewer(model);
        viewer.drawElements(gui);


        verify(gui, times(5)).drawText(any(Position.class), anyString(), anyString());
        verify(gui).drawText(new Position(7, 5), "Pause", "#9FC1E9");
        verify(gui).drawText(new Position(7, 10), "Resume", "#F1E20E"); // 10 + 2*0
        verify(gui).drawText(new Position(7, 12), "Menu", "#C4C4C4");   // 10 + 2*1
        verifyNoMoreInteractions(gui);
    }

    @Test
    public void testEmptyMenu() {
        GUI gui = Mockito.mock(GUI.class);
        Pause model = Mockito.mock(Pause.class);
        when(model.getNumberEntries()).thenReturn(0);

        PauseViewer viewer = new PauseViewer(model);
        viewer.drawElements(gui);

        verify(gui).drawText(new Position(7, 5), "Pause", "#9FC1E9");
        verify(gui).drawText(new Position(4, 25), "Press Enter", "#C4C4C4");
        verify(gui).drawText(new Position(5, 26), "to Select", "#C4C4C4");
        verify(gui, times(3)).drawText(any(Position.class), anyString(), anyString());
        verifyNoMoreInteractions(gui);
    }
}