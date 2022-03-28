package Services.UMLActions;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import Services.*;
import Services.EditComponentsService.StatusSelect;
import View.EditArea;
import View.Components.base.BaseObj;
import View.Components.base.Entity;
import View.Components.base.UMLContainer;
import View.Components.Composite;

public class Select extends MouseAdapter {
    EditComponentsService service;
    View.Components.Select view;
    Point locStart;
    List<UMLContainer> cList;
    List<BaseObj> moveObjList;

    public Select(EditComponentsService service) {
        this.service = service;
        this.view = null;
        this.cList = new ArrayList<UMLContainer>();
        this.moveObjList = new ArrayList<BaseObj>();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        EditArea editArea = service.gEditArea();
        this.locStart = e.getPoint();
        if (service.select(locStart) == StatusSelect.NONE) {
            this.view = new View.Components.Select(editArea, locStart);
            service.addComponent(this.view);
            return;
        }
        this.setMoveList();
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
            for (BaseObj item : this.moveObjList) {
            item.changeLocation(dir.x, dir.y);
            }
            for (UMLContainer item : this.cList) {
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
        this.setMoveList();
    }

    Point getMoveDir(Point p) {
        return new Point(p.x - this.locStart.x, p.y - this.locStart.y);
    }

    void addRootParent(BaseObj item) {
        UMLContainer root = null;
        for (UMLContainer p = item.getParent(); p != null; p = p.getParent()) {
            root = p;
        }
        if (!this.cList.contains(root)) {
            this.cList.add(root);
        }
    }

    void setMoveList() {
        this.moveObjList.clear();
        this.cList.clear();

        List<BaseObj> baseObjList = service.getSelectList();
        for (BaseObj item : baseObjList) {
            if (item.getParent() == null) {
                this.moveObjList.add(item);
            } else {
                this.addRootParent(item);
            }
        }
    }
}
