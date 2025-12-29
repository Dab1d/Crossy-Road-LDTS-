package controller.game;

import CrossyRoad.Controller.Game.MoveStrategies.MoveLeftStrategy;
import CrossyRoad.Controller.Game.TruckController;
import CrossyRoad.model.game.elements.Truck;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.state.StateManager;
import CrossyRoad.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito; // Importar Mockito

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
// Opcional: Para verificares se métodos foram chamados


public class TruckControllerTest {

    private Space space;
    private TruckController controller;
    private StateManager game; // Agora este será o Mock

    @BeforeEach
    public void setup() {
        // 1. Criar o Espaço e os Trucks "reais" (POJOs - Plain Old Java Objects)
        // Não precisamos de "mockar" dados simples, é melhor usar os reais para garantir a lógica.
        space = new Space(10, 10);

        Truck truck1 = new Truck(0, 5, 1, new MoveLeftStrategy());
        Truck truck2 = new Truck(9, 5, 1, new MoveLeftStrategy());

        ArrayList<Truck> trucks = new ArrayList<>();
        trucks.add(truck1);
        trucks.add(truck2);
        space.setTrucks(trucks);

        controller = new TruckController(space);

        // 2. MOCKITO MAGIC: Criar um Game falso
        // Isto cria um objeto que "parece" um Game, mas todos os métodos estão vazios.
        // Não carrega imagens, não lê ficheiros, não pede Factory.
        game = Mockito.mock(StateManager.class);
    }

    @Test
    public void step_movesTrucks() {
        // Preparação
        space.getTruck().get(0).getPosition().setX(5);
        space.getTruck().get(1).getPosition().setX(7);

        int truck1X = space.getTruck().get(0).getPosition().getX();
        int truck2X = space.getTruck().get(1).getPosition().getX();

        // Execução
        // Passamos o 'game' falso. O controller aceita-o, mas se tentar chamar algo nele,
        // não vai acontecer nada (a menos que configuremos comportamento, o que não é preciso aqui).
        controller.step(game, GUI.ACTION.NONE, 500);

        // Verificação
        assertEquals(truck1X - 1, space.getTruck().get(0).getPosition().getX());
        assertEquals(truck2X - 1, space.getTruck().get(1).getPosition().getX());
    }

    @Test
    public void step_wrapsTrucks() {
        // Preparação: Truck na borda esquerda (0)
        space.getTruck().get(0).getPosition().setX(0);

        // Execução
        controller.step(game, GUI.ACTION.NONE, 500);

        // Verificação: Deve ir para a borda direita (9)
        assertEquals(space.getWidth() - 1, space.getTruck().get(0).getPosition().getX());
    }
}