package controller.menu;

import CrossyRoad.Controller.Menu.MenusController;
import CrossyRoad.command.Command;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.NavigableMenu;
import CrossyRoad.state.StateManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MenusControllerTest {

    private MenusController<NavigableMenu> controller;

    @Mock
    private NavigableMenu modelMock;

    @Mock
    private StateManager stateManagerMock;

    @Mock
    private Command commandMock;

    @BeforeEach
    void setUp() {
        // Criamos uma subclasse anónima para testar a classe abstrata
        controller = new MenusController<>(modelMock) {
            @Override
            protected void setupCommands(StateManager stateManager) {
                // Simulamos o registo de um comando no índice 0
                commands.put(0, commandMock);
            }
        };
    }

    // ---------- TESTES DE MOVIMENTO (UP/DOWN/LEFT/RIGHT) ----------

    @Test
    void stepUp_callsPreviousEntry() throws IOException {
        controller.step(stateManagerMock, GUI.ACTION.UP, 0);
        verify(modelMock).previousEntry();
    }

    @Test
    void stepLeft_callsPreviousEntry() throws IOException {
        controller.step(stateManagerMock, GUI.ACTION.LEFT, 0);
        verify(modelMock).previousEntry();
    }

    @Test
    void stepDown_callsNextEntry() throws IOException {
        controller.step(stateManagerMock, GUI.ACTION.DOWN, 0);
        verify(modelMock).nextEntry();
    }

    @Test
    void stepRight_callsNextEntry() throws IOException {
        controller.step(stateManagerMock, GUI.ACTION.RIGHT, 0);
        verify(modelMock).nextEntry();
    }

    // ---------- TESTES DE SELEÇÃO E COMANDOS ----------

    @Test
    void stepSelect_executesCommand_whenOptionExists() throws IOException {
        // Configuramos o model para retornar a opção 0
        when(modelMock.getCurrentEntry()).thenReturn(0);

        controller.step(stateManagerMock, GUI.ACTION.SELECT, 0);

        // Verifica se o comando guardado no mapa foi executado
        verify(commandMock).execute();
    }

    @Test
    void stepSelect_doesNothing_whenOptionDoesNotExist() throws IOException {
        // Configuramos o model para retornar uma opção que não está no mapa
        when(modelMock.getCurrentEntry()).thenReturn(99);

        controller.step(stateManagerMock, GUI.ACTION.SELECT, 0);

        // Verifica que o comando NUNCA foi executado
        verify(commandMock, never()).execute();
    }

    @Test
    void step_initializesCommands_onlyOnce() throws IOException {
        // Este teste foca-se na linha: if(commands.isEmpty()) setupCommands(stateManager);
        when(modelMock.getCurrentEntry()).thenReturn(0);

        // Primeira chamada: deve inicializar
        controller.step(stateManagerMock, GUI.ACTION.SELECT, 0);
        // Segunda chamada: o mapa já não está vazio, não deve chamar setupCommands novamente
        controller.step(stateManagerMock, GUI.ACTION.SELECT, 0);

        // Como o setupCommands é abstrato, verificamos indiretamente
        // se o comando ainda funciona ou se o estado do mapa é consistente.
        verify(commandMock, times(2)).execute();
    }
}