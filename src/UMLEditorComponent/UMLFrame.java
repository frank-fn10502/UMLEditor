package UMLEditorComponent;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

import EditMode.BaseObj.*;
import EditMode.ConnectionLine.*;

public class UMLFrame extends JFrame {

    public UMLFrame() throws IOException {
        super();
        setFrameValue();
        
        // add all component to main frame
        this.setJMenuBar(menuBar());
        this.add(sideBar());
        this.add(editArea());
    }

    public EditArea editArea() {
        return EditArea.gInstance();
    };

    public SideBar sideBar() {
        return SideBar.gInStance();
    };
    public UMLMenuBar menuBar() {
        return UMLMenuBar.gInStance();
    };

    void setFrameValue() {
        this.setSize(1280, 720);// 設定視窗大小
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
    }
}
