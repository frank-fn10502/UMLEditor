package View;

import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import View.Buttons.UMLButton;

public class SideBar extends JPanel {
    UMLButton btnClicked;
    public UMLButton btnSelect, btnAL, btnGL, btnCL, btnCreateClass, btnCreateUseCase;

    public SideBar(Rectangle loc_size) throws IOException {
        super();

        setPanelValue(loc_size);
        createBtns();
        bindListener();
    }

    public void setCurrentClicked(UMLButton btn) {
        btn.activate();

        if (this.btnClicked == null) {
            this.btnClicked = btn;
            return;
        }
        if(this.btnClicked == btn){
            return;
        }
        this.btnClicked.setNormal();
        this.btnClicked = btn;
    }

    UMLButton createBtn(String path, int y) {
        UMLButton btn = new UMLButton();
        btn.setBounds(0, y, this.getWidth(), this.getWidth());
        btn.setImage(path);

        return btn;
    }

    void setPanelValue(Rectangle r) {
        this.setBounds(r);
        this.setLayout(null);
    }

    void createBtns() throws IOException {
        int gap = 10;
        int start = 0, i = this.getWidth() + gap;
        btnSelect = createBtn("/images/select.png", start);
        btnAL = createBtn("/images/AL.png", start += i);
        btnGL = createBtn("/images/GL.png", start += i);
        btnCL = createBtn("/images/CL.png", start += i);
        btnCreateClass = createBtn("/images/class.png", start += i);
        btnCreateUseCase = createBtn("/images/use_case.png", start += i);

        this.add(btnSelect);
        this.add(btnAL);
        this.add(btnGL);
        this.add(btnCL);
        this.add(btnCreateClass);
        this.add(btnCreateUseCase);
    }

    void bindListener() {
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
}
