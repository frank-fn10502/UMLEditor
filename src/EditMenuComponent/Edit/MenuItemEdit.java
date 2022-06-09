package EditMenuComponent.Edit;

import javax.swing.*;

import EditAreaComponent.UMLObject;
import EditMode.Listener.SelectListener;
import UMLEditorComponent.*;

import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public abstract class MenuItemEdit extends JMenuItem implements SelectListener{
    protected List<UMLObject> umlObjs;
    protected EditArea editArea;

    public MenuItemEdit(String text) {
        super(text);
        this.editArea = EditArea.gInstance();
        this.setEnabled(false);
    }

    @Override
    public void selectChanged(List<UMLObject> umlObjs) {
        this.umlObjs = umlObjs;
    }
}
