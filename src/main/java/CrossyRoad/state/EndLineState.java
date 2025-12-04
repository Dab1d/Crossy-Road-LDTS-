package CrossyRoad.state;

import CrossyRoad.Controler.Controller;
import CrossyRoad.Controler.Menu.EndLineController;
import CrossyRoad.model.menu.EndLine;
import CrossyRoad.view.Viewer;
import CrossyRoad.view.menu.EndLineView;

public class EndLineState extends State<EndLine> {

    public EndLineState() {
        super(new EndLine());
    }

    @Override
    public Viewer<EndLine> getViewer() {
        return new EndLineView(getModel());
    }

    @Override
    public Controller<EndLine> getController() {
        return new EndLineController(getModel());
    }
}







