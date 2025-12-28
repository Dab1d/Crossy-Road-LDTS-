package CrossyRoad.gui;

import CrossyRoad.model.Position;
import com.googlecode.lanterna.TextColor;

import java.io.IOException;

public interface GUI {

    ACTION getNextAction() throws IOException;

    void drawCharacter(int x, int y, char c, String color);

    void drawText(Position position, String text, String color);

    void drawText(Position position, String text, String color, String bg);

    void drawPixel(double x, double y, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;


    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, PAUSE}
}
