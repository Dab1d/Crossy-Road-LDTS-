package CrossyRoad;

import CrossyRoad.Controller.Game.GameController;
import CrossyRoad.gui.LanternaGUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    public static void main(String[] args) {
        try {
            // 1. Iniciar a GUI (Camada de Apresentação)
            LanternaGUI gui = new LanternaGUI(20, 32);
            // 2. Iniciar o Modelo (Camada de Dados)
            Game game = new Game();
            // 3. Iniciar o Controlador (Camada de Lógica/Motor)
            GameController controller = new GameController(game, gui);
            controller.start();

        } catch (IOException | URISyntaxException | FontFormatException e) {
            e.printStackTrace();
            System.out.println("Erro" + e.getMessage());
        }
    }
}