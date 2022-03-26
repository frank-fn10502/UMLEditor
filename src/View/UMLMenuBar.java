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
    void setMenuItem(JMenu menu){
        groupObj = new JMenuItem("Group");
        unGroupObj = new JMenuItem("UnGroup");
        changeObjName = new JMenuItem("change object name");

        menu.add(groupObj);
        menu.add(unGroupObj);
        menu.add(changeObjName);
    }

    public void setGroupListener(ActionListener listener){
        this.groupObj.addActionListener(listener);
    }
    public void setUnGroupObjListener(ActionListener listener){
        this.unGroupObj.addActionListener(listener);
    }
    public void setChangeObjNameListener(ActionListener listener){
        this.changeObjName.addActionListener(listener);
    }
}
