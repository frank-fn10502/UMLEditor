package View;

import javax.swing.*;

public class UMLMenuBar extends JMenuBar {
    public UMLMenuBar() {
        super();

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        
        JMenuItem groupObj = new JMenuItem("Group");
        JMenuItem unGroupObj = new JMenuItem("UnGroup");
        JMenuItem changeObjName = new JMenuItem("change object name");

        edit.add(groupObj);
        edit.add(unGroupObj);
        edit.add(changeObjName);
    
        this.add(file);
        this.add(edit);
    }
}
