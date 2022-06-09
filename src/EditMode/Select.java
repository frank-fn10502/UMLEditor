package EditMode;

import java.util.ArrayList;
import java.util.List;

import EditAreaComponent.EditComponent;
import EditAreaComponent.SelectArea;
import EditAreaComponent.UMLObject;
import EditMode.Listener.SelectListener;

import java.awt.*;
import java.awt.event.MouseEvent;

import UMLEditorComponent.EditArea;

public class Select extends Baseclass {
    SelectArea selectArea;
    Point locStart;
    List<UMLObject> umlObjs;
    List<SelectListener> listeners;

    public Select() {
        super();

        umlObjs = new ArrayList<UMLObject>();
        selectArea = null;
        locStart = null;

        listeners = new ArrayList<>();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (this.selectArea != null) {
            this.updateSelectArea(e.getPoint());
            return;
        }

        Point dir = this.calMoveDir(e.getPoint());
        for (UMLObject umlObject : this.umlObjs) {
            umlObject.moveDirection(dir.x, dir.y);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.locStart = e.getPoint();

        if (this.isAlreadySelected(e.getPoint()))
            return;

        this.clearAllSelectUMLObj();

        UMLObject obj = this.gInteractUMLObject(this.locStart);

        if (obj == null) {
            this.selectArea = new SelectArea(this.locStart);
            this.editArea.addComponent(this.selectArea);
            return;
        }

        this.selectArea = null;
        obj.select(true);
        this.umlObjs.add(obj);
        this.notifySelectListener();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (this.selectArea != null) {
            this.editArea.removeComponent(this.selectArea);
            this.selectArea = null;
        }
    }

    public void addSelectListener(SelectListener listener) {
        this.listeners.add(listener);
    }

    void notifySelectListener() {
        for (SelectListener listener : listeners) {
            listener.selectChanged(new ArrayList<>(this.umlObjs));
        }
    }

    public void clearAllSelectUMLObj() {
        for (UMLObject umlObject : umlObjs) {
            umlObject.select(false);
        }
        umlObjs.clear();
    }

    private UMLObject gInteractUMLObject(Point p) {
        UMLObject obj = null;
        for (UMLObject c : this.editArea.gUMLObjects()) {
            if (c.isInteract(p)) {
                obj = c;
                break;
            }
        }
        return obj;
    }

    private List<UMLObject> gInteractUMLObjects(Rectangle rect) {
        List<UMLObject> objs = new ArrayList<>();
        for (UMLObject c : this.editArea.gUMLObjects()) {
            if (c.isInteract(rect)) {
                objs.add(c);
            }
        }
        return objs;
    }

    private void updateSelectArea(Point endLoc) {
        this.selectArea.changeArea(endLoc);

        for (UMLObject umlObject : this.umlObjs) {
            umlObject.select(false);
        }

        this.umlObjs = this.gInteractUMLObjects(this.selectArea.gSelectArea());

        for (UMLObject umlObject : this.umlObjs) {
            umlObject.select(true);
        }

        this.notifySelectListener();
    }

    private Point calMoveDir(Point endLoc) {
        Point dir = new Point(endLoc.x - this.locStart.x, endLoc.y - this.locStart.y);
        this.locStart = endLoc;
        return dir;
    }

    private boolean isAlreadySelected(Point p) {
        for (UMLObject umlObject : umlObjs) {
            if (umlObject.isInteract(p))
                return true;
        }
        return false;
    }

    @Override
    public void clearModeState() {
        super.clearModeState();
        this.clearAllSelectUMLObj();
    }
}
