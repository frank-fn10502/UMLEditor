package View;

import java.awt.*;
import javax.swing.*;

public class UMLFrame extends JFrame {
    public EditArea editArea;
    public SideBar sideBar;
    public UMLMenuBar menubar;

    public UMLFrame() {
        super();
        setFrameValue();

        // create sideBar
        Rectangle loc_size = new Rectangle(10, 10, 100, 670);
        this.sideBar = new SideBar(loc_size);

        // create EditArea
        loc_size = new Rectangle(sideBar.getWidth() + sideBar.getX() + 10, 10, 1150, 670);
        this.editArea = new EditArea(loc_size);

        // create menubar
        this.menubar = new UMLMenuBar();

        // add all component to main frame
        this.setJMenuBar(menubar);
        this.add(sideBar);
        this.add(editArea);

        // 顯示視窗
        this.setVisible(true);
    }

    void setFrameValue() {
        this.setSize(1280, 720);// 設定視窗大小
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
    }

    JButton createBtn(String text, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(0, y, 100, 100);

        return btn;
    }
}
