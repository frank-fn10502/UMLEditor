package View.Buttons;

import java.awt.Color;

import javax.swing.*;

public class UMLButton extends JButton {
    Color normal, activate;

    public UMLButton(String text) {
        super(text);

        this.normal = Color.white;
        this.activate = Color.pink;

        this.setBackground(this.normal);
    }

    public void activate() {
        this.setBackground(this.activate);
    }

    public void setNormal() {
        this.setBackground(this.normal);
    }
}
