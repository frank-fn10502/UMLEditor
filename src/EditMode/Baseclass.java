package EditMode;

import java.awt.*;
import java.awt.event.*;

import EditAreaComponent.BaseObj;
import UMLEditorComponent.EditArea;

public class Baseclass extends MouseAdapter{
    protected EditArea editArea;

    public Baseclass() {
        super();
        this.editArea = EditArea.gInstance();
    }

    protected BaseObj gInteractBaseObj(Point p){
        BaseObj obj = null;
        for (BaseObj c : editArea.gBaseObjs()) {
            if (c.isInteract(p)) {
                obj = c;
                break;
            }
        }
        return obj;
    }

    public void clearModeState(){
        //由繼承的 class 實作
    }
}
