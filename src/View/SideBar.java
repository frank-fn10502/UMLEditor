package View;

import java.awt.*;

import javax.swing.*;

import View.Buttons.UMLButton;

public class SideBar extends JPanel {
    UMLButton btnClicked;
    public UMLButton btnSelect, btnAL, btnGL, btnCL, btnCreateClass, btnCreateUseCase;

    public SideBar(Rectangle r) {
        super();
        this.setBounds(r);
        this.setLayout(null);

        int gap = 10;
        int start = 0, i = r.width + gap;
        btnSelect = createBtn("select", start);
        btnAL = createBtn("AL", start += i);
        btnGL = createBtn("GL", start += i);
        btnCL = createBtn("CL", start += i);
        btnCreateClass = createBtn("class", start += i);
        btnCreateUseCase = createBtn("use case", start += i);

        this.add(btnSelect);
        this.add(btnAL);
        this.add(btnGL);
        this.add(btnCL);
        this.add(btnCreateClass);
        this.add(btnCreateUseCase);

        btnSelect.addActionListener(e -> {
            this.setCurrentClicked(btnSelect);
        });
        btnAL.addActionListener(e -> {
            this.setCurrentClicked(btnAL);
        });
        btnGL.addActionListener(e -> {
            this.setCurrentClicked(btnGL);
        });
        btnCL.addActionListener(e -> {
            this.setCurrentClicked(btnCL);
        });
        btnCreateClass.addActionListener(e -> {
            this.setCurrentClicked(btnCreateClass);
        });
        btnCreateUseCase.addActionListener(e -> {
            this.setCurrentClicked(btnCreateUseCase);
        });
    }

    public void setCurrentClicked(UMLButton btn) {
        btn.activate();

        if (this.btnClicked == null) {
            this.btnClicked = btn;
            return;
        }
        this.btnClicked.setNormal();
        this.btnClicked = btn;
    }

    UMLButton createBtn(String text, int y) {
        UMLButton btn = new UMLButton(text);
        btn.setBounds(0, y, this.getWidth(), this.getWidth());

        return btn;
    }
}
