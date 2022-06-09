package UMLEditorComponent;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import EditMode.Baseclass;

import javax.imageio.ImageIO;

public class UMLButton extends JButton {
    Color normal, activate;
    private Baseclass mode;
    private EditArea editArea;

    public UMLButton(Baseclass mode) {
        super();
        this.editArea = EditArea.gInstance();
        this.mode = mode;

        this.normal = Color.white;
        this.activate = Color.gray;

        this.addActionListener(e -> {
            this.changeMode();
        });
        this.setBackground(this.normal);
    }

    public void setImage(String path) {
        ImageIcon img = new ImageIcon(getClass().getResource(path));
        Image newimg = img.getImage().getScaledInstance(
                this.getWidth(),
                this.getWidth(),
                java.awt.Image.SCALE_SMOOTH);
        this.setIcon(new ImageIcon(newimg));
    }

    public void activate() {
        this.setBackground(this.activate);
    }

    public void setNormal() {
        this.setBackground(this.normal);
    }

    public Baseclass gEditMode(){
        return this.mode;
    }

    public void changeMode(){
        this.editArea.changeEditMode(this.mode);
    }
}
