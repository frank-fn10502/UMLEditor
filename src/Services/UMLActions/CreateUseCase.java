package Services.UMLActions;

import java.awt.event.*;
import Services.*;
import View.EditArea;
import View.Components.*;

public class CreateUseCase extends MouseAdapter {
    EditComponentsService service;

    public CreateUseCase(EditComponentsService service) {
        this.service = service;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        EditArea editArea = service.gEditArea();
        service.addComponent(
                new UseCase(editArea, e.getPoint()));
    }
}
