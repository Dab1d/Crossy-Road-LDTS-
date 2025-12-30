package view.menu;

import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.view.menu.HUDView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class HUDViewTest {
    private GUI gui;
    private HUDView hudView;

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(GUI.class);
        hudView = new HUDView();
    }

    @Test
    void testDrawHUD() {
        int score = 42;
        int level = 5;

        hudView.draw(gui, score, level);
        verify(gui, times(1)).drawText(
                eq(new Position(1, 0)),
                eq("Score: 42"),
                anyString()
        );
        verify(gui, times(1)).drawText(
                eq(new Position(11, 0)),
                eq("Level: 5"),
                anyString()
        );
    }
}