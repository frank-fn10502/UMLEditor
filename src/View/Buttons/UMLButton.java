package View.Buttons;

import java.awt.*;

import javax.swing.*;
import javax.imageio.ImageIO;

public class UMLButton extends JButton {
    Color normal, activate;


    public UMLButton() {
        super();

        this.normal = Color.white;
        this.activate = Color.gray;

        this.setBackground(this.normal);
    }

    public void setImage(String path){
        ImageIcon img = new ImageIcon(getClass().getResource(path));
        Image newimg = img.getImage().getScaledInstance(this.getWidth(), this.getWidth(), java.awt.Image.SCALE_SMOOTH);
        this.setIcon(new ImageIcon(newimg));
        // System.out.println(getClass().getResource("/images/class.png"));
    }

    public void activate() {
        this.setBackground(this.activate);
    }

    public void setNormal() {
        this.setBackground(this.normal);
    }
}
