//package controller.menu;
//
//import CrossyRoad.state.State;
//import CrossyRoad.Controller.Menu.PauseController;
//import CrossyRoad.state.StateManager;
//import CrossyRoad.gui.GUI;
//import CrossyRoad.model.menu.Pause;
//import CrossyRoad.state.MenuState;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.mockito.Mockito.*;
//@ExtendWith(MockitoExtension.class)
//public class PauseControllerTest {
//    private PauseController controller;
//<<<<<<< HEAD
//
//    @Mock
//    private Pause pauseMock;
//
//    @Mock
//    private StateManager gameMock;
//=======
//    @Mock private Pause pauseMock;
//    @Mock private Game gameMock;
//>>>>>>> 7801c4d4e6a6a8f61d8ca0cd1716e2159a9b9160
//
//    @BeforeEach
//    void setUp() { controller = new PauseController(pauseMock); }
//
//    @Test
//    void stepSelect_Resume() throws Exception {
//        when(pauseMock.getCurrentEntry()).thenReturn(0);
//        controller.step(gameMock, GUI.ACTION.SELECT, 0);
//        verify(gameMock).resumeGame();
//    }
//
//    @Test
//    void stepSelect_ReturnToMenu() throws Exception {
//        when(pauseMock.getCurrentEntry()).thenReturn(1);
//        controller.step(gameMock, GUI.ACTION.SELECT, 0);
//        verify(gameMock).returnToMenu();
//    }
//
//    @Test
//    void stepSelect_Quit() throws Exception {
//        when(pauseMock.getCurrentEntry()).thenReturn(2);
//        controller.step(gameMock, GUI.ACTION.SELECT, 0);
//        verify(gameMock).quitGame();
//    }
//}
