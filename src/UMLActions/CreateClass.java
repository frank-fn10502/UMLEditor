package UMLActions;

import java.awt.event.*;
import Services.*;
import View.EditArea;
import View.Components.*;

public class CreateClass extends MouseAdapter {
    EditComponentsService service;

    public CreateClass(EditComponentsService service) {
        this.service = service;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        EditArea editArea = service.gEditArea();
        service.addComponent(
                new UMLClass(editArea, e.getPoint()));
    }
}
