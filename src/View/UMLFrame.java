package View;

import java.awt.*;
import javax.swing.*;

public class UMLFrame extends JFrame {
    public EditArea editArea;
    public SideBar sideBar;

    public UMLFrame() {
        this.setSize(1280, 720);// 設定視窗大小
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);

        this.sideBar = new SideBar(new Rectangle(10, 10, 100, 700));

        this.editArea = new EditArea();
        this.editArea.setBounds(sideBar.getWidth() + sideBar.getX() + 10, 10, 1150, 700);
        this.editArea.setBorder(BorderFactory.createLineBorder(Color.black));

        UMLMenuBar menubar = new UMLMenuBar();

        this.setJMenuBar(menubar);
        this.add(sideBar);
        this.add(editArea);

        this.setVisible(true);// 顯示視窗
    }

    void test() {
        JMenuItem item1, item2, item3, item4;
        JMenu demo1 = new JMenu("demo1");
        item1 = new JMenuItem("one");
        item2 = new JMenuItem("two");
        demo1.add(item1);
        demo1.add(item2);
        JMenu demo2 = new JMenu("demo2");
        item3 = new JMenuItem("three");
        item4 = new JMenuItem("four");
        demo2.add(item3);
        demo2.add(item4);

        JMenuBar menubar = new JMenuBar();
        menubar.add(demo1);
        menubar.add(demo2);

        this.setJMenuBar(menubar);
    }

    JButton createBtn(String text, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(0, y, 100, 100);

        return btn;
    }
}
