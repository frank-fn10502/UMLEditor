package EditMode.BaseObj;

import java.awt.event.MouseEvent;

import EditAreaComponent.BaseObj;

import java.awt.Point;

import EditMode.Baseclass;

public class Create extends Baseclass{

    private Helper helper;

    public Create(Helper helper) {
        super();
        this.helper = helper;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point mousePoint = e.getPoint();

        BaseObj baseObj = this.helper.gBaseObj(mousePoint);
        this.editArea.addBaseObj(baseObj);
    }
}
