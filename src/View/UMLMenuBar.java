package View;

import javax.swing.*;
import java.awt.event.*;

public class UMLMenuBar extends JMenuBar {
    JMenuItem groupObj, unGroupObj, changeObjName;

    public UMLMenuBar() {
        super();

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");

        setMenuItem(edit);

        this.add(file);
        this.add(edit);
    }

    void setMenuItem(JMenu menu) {
        this.groupObj = new JMenuItem("Group");
        this.unGroupObj = new JMenuItem("UnGroup");
        this.changeObjName = new JMenuItem("change object name");

        menu.add(this.groupObj);
        menu.add(this.unGroupObj);
        menu.add(this.changeObjName);

        this.groupObj.setEnabled(false);
        this.unGroupObj.setEnabled(false);
        this.changeObjName.setEnabled(false);
    }

    public void setGroupListener(ActionListener listener) {
        this.groupObj.addActionListener(listener);
    }

    public void setUnGroupObjListener(ActionListener listener) {
        this.unGroupObj.addActionListener(listener);
    }

    public void setChangeObjNameListener(ActionListener listener) {
        this.changeObjName.addActionListener(listener);
    }

    public void EnabledMethodGroup(boolean enabled) {
        this.groupObj.setEnabled(enabled);
    }

    public void EnabledMethodUnGroupObj(boolean enabled) {
        this.unGroupObj.setEnabled(enabled);
    }

    public void EnabledMethodChangeObjName(boolean enabled) {
        this.changeObjName.setEnabled(enabled);
    }
}
