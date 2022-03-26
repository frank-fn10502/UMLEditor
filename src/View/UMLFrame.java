package View;

import java.awt.*;
import javax.swing.*;

public class UMLFrame extends JFrame {
    public EditArea editArea;
    public SideBar sideBar;
    // public JButton btnSelect, btnAL, btnGL, btnCL, btnCreateClass, btnCreateUseCase;

    public UMLFrame() {
        this.setSize(1280, 720);// 設定視窗大小
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        Container cp = this.getContentPane();

        this.sideBar = new SideBar(new Rectangle(10, 10, 100, 700));

        this.editArea = new EditArea();
        this.editArea.setBounds(sideBar.getWidth() + sideBar.getX() + 10, 10, 1150, 700);
        this.editArea.setBorder(BorderFactory.createLineBorder(Color.black));

        cp.add(sideBar, BorderLayout.WEST);
        cp.add(editArea, BorderLayout.CENTER);

        this.setVisible(true);// 顯示視窗
    }

    JButton createBtn(String text, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(0, y, 100, 100);

        return btn;
    }

    // public EditArea gEditArea() {
    //     return editArea;
    // }
}
