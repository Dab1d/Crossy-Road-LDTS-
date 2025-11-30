package CrossyRoad.view.game;


import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.Log;

public class LogViewer implements ElementViewer<Log> {
    @Override
    public void draw(Log log, GUI gui) {
        gui.drawCharacter(log.getPosition().getX(), log.getPosition().getY(), '-', "#905923");
    }
}