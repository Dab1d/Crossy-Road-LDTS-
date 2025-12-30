package view.game;

import CrossyRoad.controller.Game.MoveStrategies.MoveLeftStrategy;
import CrossyRoad.controller.Game.MoveStrategies.MoveRightStrategy;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.*;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.view.game.GameViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class GameViewerTest {
    @Test
    void testDrawElementsCallsSubViewers() {
        GUI gui = Mockito.mock(GUI.class);
        Space space = Mockito.mock(Space.class);

        Bush bush = new Bush(1, 1);
        Coin coin = new Coin(2, 2);
        Car car = new Car(3, 3, 1, new MoveRightStrategy());
        Log log = new Log(4, 4, 1, new MoveRightStrategy());
        EndLine endLine = new EndLine(5, 5);
        River river = new River(6, 6, 1, new MoveRightStrategy());
        Truck truck = new Truck(7, 7, 1, new MoveLeftStrategy());
        Wall wall = new Wall(8, 8);
        Chicken chicken = new Chicken(10, 10);

        when(space.getBushes()).thenReturn(List.of(bush));
        when(space.getCoins()).thenReturn(List.of(coin));
        when(space.getCars()).thenReturn(List.of(car));
        when(space.getLogs()).thenReturn(List.of(log));
        when(space.getEndlines()).thenReturn(List.of(endLine));
        when(space.getRiver()).thenReturn(List.of(river));
        when(space.getTruck()).thenReturn(List.of(truck));
        when(space.getWalls()).thenReturn(List.of(wall));
        when(space.getChicken()).thenReturn(chicken);

        GameViewer viewer = new GameViewer(space);
        viewer.drawElements(gui);



        // elements drawn
        verify(gui, times(1)).drawCharacter(eq(1), eq(1), anyChar(), anyString()); // Bush
        verify(gui, times(1)).drawCharacter(eq(2), eq(2), anyChar(), anyString()); // Coin
        verify(gui, times(1)).drawCharacter(eq(4), eq(4), anyChar(), anyString()); // Log
        verify(gui, times(1)).drawCharacter(eq(8), eq(8), anyChar(), anyString()); // Wall
        verify(gui, times(1)).drawCharacter(eq(10), eq(10), anyChar(), anyString()); // Chicken


        verify(gui, atLeastOnce()).drawPixel(eq(3.0), eq(3.0), anyString()); // Car
        verify(gui, atLeastOnce()).drawPixel(eq(5.0), eq(5.0), anyString()); // EndLine
        verify(gui, atLeastOnce()).drawPixel(eq(7.0), eq(7.0), anyString()); // Truck
        verify(gui, atLeastOnce()).drawCharacter(eq(6), eq(6), anyChar(), anyString());
    }

    @Test
    void testDrawElementsWithEmptyLists() {

        GUI gui = Mockito.mock(GUI.class);
        Space space = Mockito.mock(Space.class);

        when(space.getBushes()).thenReturn(Collections.emptyList());
        when(space.getCoins()).thenReturn(Collections.emptyList());
        when(space.getCars()).thenReturn(Collections.emptyList());
        when(space.getLogs()).thenReturn(Collections.emptyList());
        when(space.getEndlines()).thenReturn(Collections.emptyList());
        when(space.getRiver()).thenReturn(Collections.emptyList());
        when(space.getTruck()).thenReturn(Collections.emptyList());
        when(space.getWalls()).thenReturn(Collections.emptyList());
        when(space.getChicken()).thenReturn(new Chicken(0,0));

        GameViewer viewer = new GameViewer(space);
        viewer.drawElements(gui);

        verify(space).getBushes();
        verify(gui, atLeastOnce()).drawCharacter(eq(0), eq(0), anyChar(), anyString());

    }
}