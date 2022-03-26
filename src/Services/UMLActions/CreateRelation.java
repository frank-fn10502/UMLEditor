package Services.UMLActions;

import java.awt.*;
import java.awt.event.*;
import Services.*;
import View.Components.*;

public class CreateRelation<T extends View.Components.Relation> extends MouseAdapter {
    EditComponentsService service;
    BaseObj objStart;
    T view;
    boolean exitStartObj;

    public CreateRelation(EditComponentsService service) {
        this.service = service;
        this.objStart = null;
        this.exitStartObj = false;
    }

    /**
     * 需要 override
     */
    protected T getView() {
        return null;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        Point locPress = e.getPoint();
        BaseObj obj = service.getIntraComponent(locPress);

        if (obj != null) {
            this.objStart = obj;
            this.view = getView();
            service.addComponent(this.view);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (this.view == null)
            return;

        Point mousePoint = e.getPoint();
        if (objStart.isInteract(mousePoint)) {
            if (this.exitStartObj) {
                this.view.show(false);
                this.exitStartObj = false;
            }
            return;
        }

        if (!this.exitStartObj) {
            this.view.show(true);

            Point startPoint = objStart.getNearestAnchorPoint(mousePoint);
            view.setStartPoint(startPoint);
            this.exitStartObj = true;
        }

        view.setEndPoint(mousePoint);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (this.view == null)
            return;

        Point locPress = e.getPoint();
        BaseObj obj = service.getIntraComponent(locPress);
        if (obj == null) {
            service.removeComponent(this.view);
            this.view = null;
            return;
        }

        if (obj == this.objStart) {
            service.removeComponent(this.view);
            this.view = null;
            return;
        }

        Point endPoint = obj.getNearestAnchorPoint(locPress);
        view.setEndPoint(endPoint);
        this.view = null;
    }
}
