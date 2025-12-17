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

        // Check Botton Back selected
        when(model.getNumberEntries()).thenReturn(1);
        when(model.getEntry(0)).thenReturn("Back");
        when(model.isSelected(0)).thenReturn(true);

        HelpView viewer = new HelpView(model);
        viewer.drawElements(gui);


        //Check titles
        verify(gui).drawText(new Position(4, 1), "Crossy Road", "#F2BD97");
        verify(gui).drawText(new Position(3, 14), " Instructions", "#F2BD97");

        //Check help content with yellow color
        verify(gui).drawText(new Position(3, 3), "Avoid cars and", "#C4C4C4");
        verify(gui).drawText(new Position(2, 7), "save the chicken", "#C4C4C4");
        verify(gui).drawText(new Position(3, 16), "Use arrow keys", "#C4C4C4");

        verify(gui).drawText(
                new Position(4, 25),
                "Back",
                "#F1E20E" //
        );
    }
}