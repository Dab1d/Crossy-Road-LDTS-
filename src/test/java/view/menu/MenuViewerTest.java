package view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.view.menu.MenuView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
/**
public class MenuViewerTest {
    @Test
    public void testDrawBackgroundAndEntries() {

        GUI gui = Mockito.mock(GUI.class);
        Menu model = Mockito.mock(Menu.class);

        List<String> mockBackground = Arrays.asList("ad");
        when(model.getBackground()).thenReturn(mockBackground);
        //when(model.getBackgroundColor()).thenReturn("#0000FF"); // Azul de fundo
        when(model.getNumberEntries()).thenReturn(2);

        //  0 "Start" Selected-> #F1E20E
        when(model.getEntry(0)).thenReturn("Start");
        when(model.isSelected(0)).thenReturn(true);

        // "Exit" Not Selected -> #C4C4C4
        when(model.getEntry(1)).thenReturn("Exit");
        when(model.isSelected(1)).thenReturn(false);

        MenuView viewer = new MenuView(model);
        viewer.drawElements(gui);

        // 'a' on  (0,0) -> #000000
        verify(gui).drawPixel(0, 0, "#000000");
        // 'd' on (1,0) -> #FF0000
        verify(gui).drawPixel(1, 0, "#FF0000");

        //Check title
        verify(gui).drawText(new Position(8, 1), "Menu", "#FFFFFF", "#0000FF");
        // Botton 0 ("Start") Pos X = 2 + 0 = 2. Color (#F1E20E)
        verify(gui).drawText(
                new Position(2, 4),
                "Start",
                "#00fef8",
                "#0000FF"
        );

        // Button 1 ("Exit"): Pos X = 2 + 6 = 8. Color not selected (#C4C4C4)
        verify(gui).drawText(
                new Position(8, 4),
                "Exit",
                "#FFFFFF",
                "#0000FF"
        );
    }
    @Test
    public void testUnknownCharacterInMap() {
        GUI gui = Mockito.mock(GUI.class);
        Menu model = Mockito.mock(Menu.class);

        //char z that doesn't belong to doc
        when(model.getBackground()).thenReturn(Arrays.asList("z"));

        MenuView viewer = new MenuView(model);
        viewer.drawElements(gui);

        // should be default color #FFFFFF
        verify(gui).drawPixel(0, 0, "#FFFFFF");
    }
    @Test
    public void testNullBackground() {
        GUI gui = Mockito.mock(GUI.class);
        Menu model = Mockito.mock(Menu.class);

        when(model.getBackground()).thenReturn(null);
       // when(model.getBackgroundColor()).thenReturn("#000000");

        MenuView viewer = new MenuView(model);
        viewer.drawElements(gui);

        //Check that none pixel was drawn
        verify(gui, never()).drawPixel(anyInt(), anyInt(), anyString());

        // Check text
        verify(gui).drawText(new Position(8, 1), "Menu", "#FFFFFF", "#000000");
    }
}
 */