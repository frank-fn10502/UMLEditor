package EditAreaComponent;

import java.util.List;

import UMLEditorComponent.*;

import java.awt.*;
import java.awt.event.*;

public abstract class EditComponent {
    protected int depth;
    protected boolean isSelected;
    protected boolean visible;
    protected EditArea editArea;

    public EditComponent() {
        this.editArea = EditArea.gInstance();
        this.depth = 90;
    }

    public void draw(Graphics g) {
    }

    /* === composite === */
    public void addUmLObj(UMLObject obj) {

    }

    public UMLObject removeUmLObj(UMLObject obj) {
        return null;
    }

    public List<UMLObject> getAllChilds() {
        return null;
    }
    /* ========== */

    /* === uml obj === */
    public boolean isInteract(Point p) {
        return false;
    }

    public boolean isInteract(Rectangle rect) {
        return false;
    }

    public void moveDirection(int x, int y) {
        // System.out.println("default move direction do nothing");
    }
    /* ========== */

    public void select(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public void setVisible(boolean isVisible) {
        this.visible = isVisible;
    }

    public int getDepth() {
        return this.depth;
    }

    public void setDepth(int d) {
        this.depth = d;
    }
}
