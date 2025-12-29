package controller.game;

import CrossyRoad.Controller.Game.EndLineController;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.state.StateManager;
import CrossyRoad.model.game.elements.Chicken;
import CrossyRoad.model.game.elements.EndLine;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.state.GameState;
import CrossyRoad.state.WinState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EndLineControllerTest {

    private EndLineController controller;

    @Mock
    private Space spaceMock;
    @Mock private StateManager stateManagerMock;
    @Mock private Chicken chickenMock;

    @BeforeEach
    void setUp() {
        controller = new EndLineController(spaceMock);
        // Configuração comum: o model tem sempre uma galinha
        when(spaceMock.getChicken()).thenReturn(chickenMock);
    }

    @Test
    void step_WhenChickenReachedEndLine_CallsAdvanceLevel() throws IOException {
        // 1. Definir posição da galinha
        Position pos = new Position(10, 0);
        when(chickenMock.getPosition()).thenReturn(pos);

        // 2. Criar uma lista de EndLines onde uma coincide com a posição da galinha
        EndLine endLineMatch = new EndLine(10, 0);
        EndLine endLineOther = new EndLine(5, 0);
        when(spaceMock.getEndlines()).thenReturn(Arrays.asList(endLineOther, endLineMatch));

        // 3. Executar o step
        controller.step(stateManagerMock, GUI.ACTION.NONE, 0);

        // 4. Verificar se avançou de nível
        verify(stateManagerMock, times(1)).advanceLevel();
    }

    @Test
    void step_WhenChickenNotAtEndLine_DoesNothing() throws IOException {
        // 1. Galinha numa posição qualquer
        when(chickenMock.getPosition()).thenReturn(new Position(10, 10));

        // 2. EndLines em posições diferentes
        EndLine endLine = new EndLine(10, 0);
        when(spaceMock.getEndlines()).thenReturn(Collections.singletonList(endLine));

        // 3. Executar
        controller.step(stateManagerMock, GUI.ACTION.NONE, 0);

        // 4. Verificar que NUNCA chamou advanceLevel
        verify(stateManagerMock, never()).advanceLevel();
    }

    @Test
    void step_WhenMultipleEndLines_CallsAdvanceLevelOnlyOnce() throws IOException {
        // Caso a galinha consiga estar em "cima" de duas ao mesmo tempo (teórico)
        Position pos = new Position(10, 0);
        when(chickenMock.getPosition()).thenReturn(pos);

        EndLine e1 = new EndLine(10, 0);
        EndLine e2 = new EndLine(10, 0);
        when(spaceMock.getEndlines()).thenReturn(Arrays.asList(e1, e2));

        controller.step(stateManagerMock, GUI.ACTION.NONE, 0);

        // O 'return' dentro do loop garante que só chama uma vez
        verify(stateManagerMock, times(1)).advanceLevel();
    }
}

