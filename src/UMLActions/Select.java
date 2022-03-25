package UMLActions;

import java.awt.event.*;
import java.util.List;

import Services.*;
import Services.EditComponentsService.StatusSelect;
import View.Components.*;

import java.awt.Point;

public class Select extends MouseAdapter  {
    EditComponentsService service;
    View.Components.Select view;

    public Select(EditComponentsService service) {
        this.service = service;
        this.view = null;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (service.select(e.getPoint()) == StatusSelect.NONE) {
            // create "select view" add to Canvas
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (view != null) {
            // "select view" change size
            // service.getIntractComponent(new rect)
        } else {
            //List<BaseObj> baseObjList = service.getSelectList();
            //baseObjList 需要更動位置
        }
    }
}
