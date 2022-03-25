package UMLActions;

import java.awt.event.*;
import java.util.List;

import Services.*;
import Services.EditComponentsService.StatusSelect;
import View.EditArea;
import View.Components.*;

import java.awt.Point;

public class Select extends MouseAdapter {
    EditComponentsService service;
    View.Components.Select view;

    public Select(EditComponentsService service) {
        this.service = service;
        this.view = null;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        EditArea editArea = service.gEditArea();
        if (service.select(e.getPoint()) == StatusSelect.NONE) {
            this.view = new View.Components.Select(editArea, e.getPoint());
            service.addComponent(this.view);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (this.view != null) {
            this.view.changeSize(e.getPoint());
            service.select(this.view.getSelectArea());
        } else {
            List<BaseObj> baseObjList = service.getSelectList();
            for (BaseObj baseObj : baseObjList) {
                baseObj.changeLocation(e.getPoint());
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (this.view != null){
            service.removeComponent(this.view);
            this.view = null;
        }
    }
}
