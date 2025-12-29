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

import static org.mockito.Mockito.*;

public class GameViewerTest {

    @Test
    void testDrawElementsCallsSubViewers() {

        GUI gui = Mockito.mock(GUI.class);
        Space space = Mockito.mock(Space.class);

        Bush bush = new Bush(1, 1);
        Coin coin = new Coin(2, 2);
        Car car = new Car(3, 3,1,new MoveRightStrategy());
        Log log = new Log(4, 4,1,new MoveRightStrategy());
        EndLine endLine = new EndLine(5, 5);
        River river = new River(6, 6,1,new MoveRightStrategy());
        Truck truck = new Truck(7, 7,1,new MoveLeftStrategy());
        Wall wall = new Wall(8, 8);
        Chicken chicken = new Chicken(10, 10);

        when(space.getBushes()).thenReturn(Arrays.asList(bush));
        when(space.getCoins()).thenReturn(Arrays.asList(coin));
        when(space.getCars()).thenReturn(Arrays.asList(car));
        when(space.getLogs()).thenReturn(Arrays.asList(log));
        when(space.getEndlines()).thenReturn(Arrays.asList(endLine));
        when(space.getRiver()).thenReturn(Arrays.asList(river));
        when(space.getTruck()).thenReturn(Arrays.asList(truck));
        when(space.getWalls()).thenReturn(Arrays.asList(wall));
        when(space.getChicken()).thenReturn(chicken);


        GameViewer viewer = new GameViewer(space);
        viewer.drawElements(gui);


        // checkar GameViewer se foi buscar os dados ao Modelo
        verify(space, times(1)).getBushes();
        verify(space, times(1)).getCars();
        verify(space, times(1)).getChicken();

        verify(gui, atLeastOnce()).drawCharacter(eq(1), eq(1), anyChar(), anyString());
        verify(gui, atLeastOnce()).drawCharacter(eq(10), eq(10), anyChar(), anyString());
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