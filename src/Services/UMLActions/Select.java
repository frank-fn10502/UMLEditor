package Services.UMLActions;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

import Services.*;
import Services.EditComponentsService.StatusSelect;
import View.EditArea;
import View.Components.base.BaseObj;

public class Select extends MouseAdapter {
    EditComponentsService service;
    View.Components.Select view;
    Point locStart;

    public Select(EditComponentsService service) {
        this.service = service;
        this.view = null;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        EditArea editArea = service.gEditArea();
        this.locStart = e.getPoint();
        if (service.select(locStart) == StatusSelect.NONE) {
            this.view = new View.Components.Select(editArea, locStart);
            service.addComponent(this.view);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (this.view != null) {
            this.view.changeSize(e.getPoint());
            service.select(this.view.getSelectArea());
            return;
        }

        Point dir = this.getMoveDir(e.getPoint());
        if (dir.x != 0 || dir.y != 0) {
            List<BaseObj> baseObjList = service.getSelectList();

            for (BaseObj item : baseObjList) {
                item.changeLocation(dir.x, dir.y);
            }
            this.locStart = e.getPoint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (this.view != null) {
            service.removeComponent(this.view);
            this.view = null;
        }
    }

    Point getMoveDir(Point p) {
        return new Point(p.x - this.locStart.x, p.y - this.locStart.y);
    }
}
