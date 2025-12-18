package controller.game;

import CrossyRoad.Controller.Game.TruckController;
import CrossyRoad.model.game.elements.Truck;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.model.Position;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TruckControllerTest {

    private Space space;
    private TruckController controller;
    private Game game;

    @BeforeEach
    public void setup() throws IOException, URISyntaxException, FontFormatException {
        space = new Space(10, 10);

        Truck truck1 = new Truck(0,5);
        Truck truck2 = new Truck(9,5);

        ArrayList<Truck> trucks = new ArrayList<>();
        trucks.add(truck1);
        trucks.add(truck2);
        space.setTrucks(trucks);

        controller = new TruckController(space);
        game = new Game(); // instancia mínima se necessário
    }

    @Test
    public void step_movesTrucks() {
        // Posição inicial não na borda
        space.getTruck().get(0).getPosition().setX(5);
        space.getTruck().get(1).getPosition().setX(7);

        int truck1X = space.getTruck().get(0).getPosition().getX();
        int truck2X = space.getTruck().get(1).getPosition().getX();

        controller.step(game, GUI.ACTION.NONE, 500);

        // Velocidade = -1, direção = true, novoX = X + (-1)
        assertEquals(truck1X - 1, space.getTruck().get(0).getPosition().getX());
        assertEquals(truck2X - 1, space.getTruck().get(1).getPosition().getX());
    }


    @Test
    public void step_wrapsTrucks() {
        // Posiciona truck perto do limite esquerdo
        space.getTruck().get(0).getPosition().setX(0);
        controller.step(game, GUI.ACTION.NONE, 500);

        // O truck deve "wrap-around" para a direita
        assertEquals(space.getWidth() - 1, space.getTruck().get(0).getPosition().getX());
    }
}
