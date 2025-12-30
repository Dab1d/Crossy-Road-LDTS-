package controller.game;


import CrossyRoad.controller.Game.LogController;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.state.StateManager;
import CrossyRoad.model.game.elements.Chicken;
import CrossyRoad.model.game.elements.Log;
import CrossyRoad.model.game.space.Space;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LogControllerTest {

    private LogController controller;
    @Mock
    private Space spaceMock;
    @Mock private StateManager stateManagerMock;
    @Mock private Chicken chickenMock;
    @Mock private Log logMock;

    @BeforeEach
    void setUp() {
        controller = new LogController(spaceMock);
        when(spaceMock.getChicken()).thenReturn(chickenMock);
        when(spaceMock.getWidth()).thenReturn(20);
    }

    @Test
    void step_DoesNotMove_WhenTimeIntervalTooSmall() {
        // Primeira chamada (inicializa lastMoveTime)
        controller.step(stateManagerMock, GUI.ACTION.NONE, 1000);

        // Chamada apenas 100ms depois (menor que 200)
        controller.step(stateManagerMock, GUI.ACTION.NONE, 1100);

        verify(spaceMock, times(1)).getLogs(); // Só foi chamado na primeira vez
    }

    @Test
    void moveLog_CarryingChicken_UpdatesChickenPosition() {
        Position chickenPos = new Position(10, 5);
        when(chickenMock.getPosition()).thenReturn(chickenPos);
        when(logMock.getPosition()).thenReturn(new Position(10, 5)); // Mesma pos
        when(logMock.updatePosition(20)).thenReturn(1); // Moveu +1 para a direita
        when(spaceMock.getLogs()).thenReturn(Collections.singletonList(logMock));

        // Forçar o tempo a passar (200ms)
        controller.step(stateManagerMock, GUI.ACTION.NONE, 200);

        // A galinha deve ter sido movida para 11 (10 + 1)
        assertEquals(11, chickenPos.getX());
    }

    @Test
    void moveLog_ChickenDies_WhenPushedOutOfBounds() {
        Position chickenPos = new Position(19, 5); // No limite direito
        when(chickenMock.getPosition()).thenReturn(chickenPos);
        when(logMock.getPosition()).thenReturn(new Position(19, 5));
        when(logMock.updatePosition(20)).thenReturn(1); // Tenta mover para 20
        when(spaceMock.getLogs()).thenReturn(Collections.singletonList(logMock));

        controller.step(stateManagerMock, GUI.ACTION.NONE, 200);

        // Verifica se chamou o método de morte no model
        verify(spaceMock).isChickenDead();
    }

    @Test
    void moveLog_NoChickenOnLog_OnlyLogMoves() {
        Position chickenPos = new Position(5, 5);
        when(chickenMock.getPosition()).thenReturn(chickenPos);
        when(logMock.getPosition()).thenReturn(new Position(10, 5)); // Longe da galinha
        when(logMock.updatePosition(20)).thenReturn(-1);
        when(spaceMock.getLogs()).thenReturn(Collections.singletonList(logMock));

        controller.step(stateManagerMock, GUI.ACTION.NONE, 200);

        // A posição da galinha não deve ter mudado
        assertEquals(5, chickenPos.getX());
        verify(logMock).updatePosition(20);
    }
}

