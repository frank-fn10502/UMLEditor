package UMLEditorComponent;

import java.io.IOException;
import javax.swing.*;

import EditMode.Baseclass;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class SideBar extends JPanel {
    private static SideBar sideBar;
    UMLButton btnClicked;
    List<UMLButton> btns;

    int gap, start, count;

    SideBar() {
        super();
        btns = new ArrayList<>();

        this.setLayout(null);
        gap = 10;
        start = 0 ;
        count = 0;
    }

    public static SideBar gInStance() {
        if (sideBar == null) {
            sideBar = new SideBar();
        }
        return sideBar;
    }

    public void addUMLBtn(Baseclass mode, String path) {
        UMLButton btn = new UMLButton(mode);
        
        int y = start + (this.getWidth() + gap) * count;
        btn.setBounds(0, y, this.getWidth(), this.getWidth());
        btn.setImage(path);
        btn.addActionListener(e -> {
            this.updateActiveClicked(btn);
        });

        count++;
        this.btns.add(btn);
        this.add(btn);
    }

    void updateActiveClicked(UMLButton btn) {
        btn.activate();

        if (this.btnClicked == null) {
            this.btnClicked = btn;
            return;
        }
        if (this.btnClicked == btn) {
            return;
        }

        this.btnClicked.setNormal();
        this.btnClicked = btn;
    }

    public void activateEditMode(Baseclass mode) {
        for (UMLButton umlButton : btns) {
            if (umlButton.gEditMode() == mode) {
                this.updateActiveClicked(umlButton);
                umlButton.changeMode();
                break;
            }
        }
    }
}
