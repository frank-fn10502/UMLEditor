import EditMenuComponent.MenuEdit;
import EditMenuComponent.MenuFile;
import EditMode.BaseObj.*;
import EditMode.ConnectionLine.*;
import UMLEditorComponent.*;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UMLEditor {
    public static void main(String[] args) throws Exception {
        /* ===== init SideBar ===== */
        SideBar sideBar = SideBar.gInStance();
        Rectangle loc_size = new Rectangle(10, 10, 100, 680);
        sideBar.setBounds(loc_size);

        EditMode.Select modeSelect = new EditMode.Select();

        sideBar.addUMLBtn(modeSelect, "/images/select.png");
        sideBar.addUMLBtn(new EditMode.ConnectionLine.Create(new AssociationHelper()), "/images/AL.png");
        sideBar.addUMLBtn(new EditMode.ConnectionLine.Create(new GenerationHelper()), "/images/GL.png");
        sideBar.addUMLBtn(new EditMode.ConnectionLine.Create(new CompositionHelper()), "/images/CL.png");
        sideBar.addUMLBtn(new EditMode.BaseObj.Create(new ClassObjHelper()), "/images/class.png");
        sideBar.addUMLBtn(new EditMode.BaseObj.Create(new UseCaseHelper()), "/images/use_case.png");

        sideBar.activateEditMode(modeSelect);
        /* ========== */

        /* ===== init UMLMenuBar ===== */
        UMLMenuBar menuBar = UMLMenuBar.gInStance();

        MenuFile menuFile = new MenuFile();
        MenuEdit menuEdit = new MenuEdit();
        EditMenuComponent.Edit.Group group = new EditMenuComponent.Edit.Group(modeSelect);
        EditMenuComponent.Edit.UnGroup unGroup = new EditMenuComponent.Edit.UnGroup(modeSelect);
        EditMenuComponent.Edit.ChangeObjName changeObjName = new EditMenuComponent.Edit.ChangeObjName();

        menuEdit.add(group);
        menuEdit.add(unGroup);
        menuEdit.add(changeObjName);

        menuBar.addTier1Menu(menuFile);
        menuBar.addTier1Menu(menuEdit);
        /* ========== */

        /* ===== init EditArea ===== */
        loc_size = new Rectangle(sideBar.getWidth() + sideBar.getX() + 10, 10, 1150, 680);
        EditArea.gInstance().setBounds(loc_size);
        /* ========== */

        modeSelect.addSelectListener(group);
        modeSelect.addSelectListener(unGroup);
        modeSelect.addSelectListener(changeObjName);

        UMLFrame frame = new UMLFrame();
        frame.setTitle("UML Editor");

        // 顯示視窗
        frame.setVisible(true);
    }
}
