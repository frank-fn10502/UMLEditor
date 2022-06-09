package EditMode.ConnectionLine;

import java.awt.Point;
import java.awt.event.MouseEvent;

import EditAreaComponent.BaseObj;
import EditAreaComponent.UMLConnectionLine;
import EditMode.Baseclass;
import UMLEditorComponent.EditArea;

public class Create extends Baseclass {
    private Helper helper;
    UMLConnectionLine cl;

    BaseObj objStart;
    boolean exitStartObj;

    public Create(Helper helper) {
        super();
        this.helper = helper;
        this.cl = null;
        this.exitStartObj = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(this.cl == null) return;

        Point mousePoint = e.getPoint();
        if (objStart.isInteract(mousePoint)) {
            if (this.exitStartObj) {
                this.cl.setVisible(false);
                this.exitStartObj = false;
            }
            return;
        }

        if (!this.exitStartObj) {
            this.cl.setVisible(true);

            Point startPoint = objStart.getNearestPoint(mousePoint);
            this.cl.setStartPoint(startPoint);
            this.exitStartObj = true;
        }

        this.cl.changeEndPoint(mousePoint);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point locPress = e.getPoint();

        BaseObj obj = gInteractBaseObj(locPress);

        if (obj != null) {
            this.objStart = obj;
            this.cl = this.helper.getConnectionLine();
            editArea.addConnectionLine(this.cl);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(this.cl == null) return;

        Point locPress = e.getPoint();
        BaseObj obj = gInteractBaseObj(locPress);

        if (obj == null || obj == this.objStart) {
            this.editArea.removeConnectionLine(cl);
            this. cl = null;
            return;
        }

        Point endPoint = obj.getNearestPoint(locPress);
        this.cl.changeEndPoint(endPoint);
        this. cl = null;
    }
}
