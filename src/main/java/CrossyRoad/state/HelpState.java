package CrossyRoad.state;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Controller.Menu.HelpController;
import CrossyRoad.model.menu.Help;
import CrossyRoad.view.Viewer;
import CrossyRoad.view.menu.HelpView;

public class HelpState extends State<Help> {

    public HelpState() {
        super(new Help());
    }

    @Override
    public Viewer<Help> getViewer() {
        return new HelpView(getModel());
    }

    @Override
    public Controller<Help> getController() {
        return new HelpController(getModel());
    }
}
