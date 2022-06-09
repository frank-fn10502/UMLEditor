package UMLEditorComponent;

import EditMode.Baseclass;

import java.util.*;
import java.util.List;

import javax.swing.*;

import EditAreaComponent.BaseObj;
import EditAreaComponent.EditComponent;
import EditAreaComponent.UMLConnectionLine;
import EditAreaComponent.UMLObject;

import java.awt.*;

public class EditArea extends JPanel {
    private static EditArea editArea;
    ArrayList<EditComponent> components;
    ArrayList<BaseObj> baseObjs;
    ArrayList<UMLObject> umlObjects;
    ArrayList<UMLConnectionLine> connectionLines;
    private Baseclass editMode;

    EditArea() {
        super();
        components = new ArrayList<EditComponent>();
        baseObjs = new ArrayList<BaseObj>();
        connectionLines = new ArrayList<UMLConnectionLine>();
        umlObjects = new ArrayList<UMLObject>();

        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public static EditArea gInstance() {
        if (editArea == null) {
            editArea = new EditArea();
        }
        return editArea;
    }

    public ArrayList<EditComponent> gComponents() {
        return components;
    }

    public ArrayList<BaseObj> gBaseObjs() {
        return baseObjs;
    }

    public ArrayList<UMLObject> gUMLObjects() {
        return umlObjects;
    }

    public ArrayList<UMLConnectionLine> gConnectionLines() {
        return connectionLines;
    }

    public void sortComponent() {
        components.sort((i1, i2) -> i2.getDepth() - i1.getDepth());
        this.repaint();
    }

    public void addComponent(EditComponent c) {
        components.add(c);
        components.sort((i1, i2) -> i2.getDepth() - i1.getDepth());
        this.repaint();
    }

    public void removeComponent(EditComponent c) {
        components.remove(c);
        this.repaint();
    }

    public void addUMLObject(UMLObject c) {
        umlObjects.add(c);
        this.addComponent(c);
    }

    public void removeUMLObject(UMLObject c) {
        umlObjects.remove(c);
        this.removeComponent(c);
    }

    public void addBaseObj(BaseObj c) {
        baseObjs.add(c);
        this.addUMLObject(c);
    }

    public void removeBaseObj(BaseObj c) {
        baseObjs.remove(c);
        this.removeUMLObject(c);
    }

    public void addConnectionLine(UMLConnectionLine c) {
        connectionLines.add(c);
        this.addComponent(c);
    }

    public void removeConnectionLine(UMLConnectionLine c) {
        connectionLines.remove(c);
        this.removeComponent(c);
    }

    public void changeEditMode(Baseclass mode) {
        if (this.editMode != null)
            this.editMode.clearModeState();

        this.removeMouseListener(this.editMode);
        this.removeMouseMotionListener(this.editMode);

        this.addMouseListener(mode);
        this.addMouseMotionListener(mode);

        this.editMode = mode;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (EditComponent ec : components) {
            ec.draw(g);
        }
    }
}
