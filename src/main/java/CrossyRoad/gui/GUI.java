package CrossyRoad.gui;

import CrossyRoad.model.Position;

import java.io.IOException;

public interface GUI {

    ACTION getNextAction() throws IOException;

    void drawChicken(Position position);

    void drawWalls(Position position);

    void drawTruck(Position position);

    void drawCar(Position position);

    void drawBush(Position position);

    void drawRiver(Position position);

    void drawLog(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;


    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}
