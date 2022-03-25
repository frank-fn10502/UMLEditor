package View;

import java.awt.*;
import javax.swing.*;

public class UMLFrame extends JFrame {
    public EditArea editArea;
    public JButton btnSelect, btnAL, btnGL, btnCL, btnCreateClass, btnCreateUseCase;

    public UMLFrame() {
        this.setSize(1280, 720);// 設定視窗大小
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        Container cp = this.getContentPane();

        JPanel sideBar = new JPanel();
        sideBar.setBounds(10, 10, 100, 700);
        // sideBar.setBackground(Color.BLUE);
        sideBar.setLayout(null);

        int start = 0, i = 110;
        btnSelect = createBtn("select", start);
        btnAL = createBtn("AL", start += i);
        btnGL = createBtn("GL", start += i);
        btnCL = createBtn("CL", start += i);
        btnCreateClass = createBtn("class", start += i);
        btnCreateUseCase = createBtn("use case", start += i);

        sideBar.add(btnSelect);
        sideBar.add(btnAL);
        sideBar.add(btnGL);
        sideBar.add(btnCL);
        sideBar.add(btnCreateClass);
        sideBar.add(btnCreateUseCase);

        editArea = new EditArea();
        editArea.setBounds(sideBar.getWidth() + sideBar.getX() + 10, 10, 1150, 700);
        // editArea.setBackground(Color.GREEN);
        editArea.setBorder(BorderFactory.createLineBorder(Color.black));

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
