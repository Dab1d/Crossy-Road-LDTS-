package view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.view.menu.MenuView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class MenuViewTest {
    private GUI gui;
    private Menu menu;
    private MenuView menuView;

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(GUI.class);
        menu = Mockito.mock(Menu.class);
        menuView = new MenuView(menu);
    }

    @Test
    void testDrawElements() {
        List<String> mockBackground = Arrays.asList("a");
        when(menu.getBackground()).thenReturn(mockBackground);
        when(menu.getNumberEntries()).thenReturn(2);
        when(menu.getEntry(0)).thenReturn("Start");
        when(menu.getEntry(1)).thenReturn("Quit");

        when(menu.isSelected(0)).thenReturn(true);
        when(menu.isSelected(1)).thenReturn(false);

        menuView.drawElements(gui);

        verify(gui, atLeastOnce()).drawPixel(anyDouble(), anyDouble(), anyString());
        verify(gui).drawText(eq(new Position(8, 1)), eq("Menu"), eq("#FFFFFF"), eq("#b914c8"));
        verify(gui).drawText(eq(new Position(2, 4)), eq("Start"), eq("#00fef8"), eq("#b914c8"));
        verify(gui).drawText(eq(new Position(8, 4)), eq("Quit"), eq("#FFFFFF"), eq("#b914c8"));
        verify(gui, times(3)).drawText(any(Position.class), anyString(), anyString(), anyString());
        verifyNoMoreInteractions(gui);
    }
}