package UMLEditorComponent;

import javax.swing.*;

import EditMenuComponent.MenuEdit;
import EditMenuComponent.MenuFile;
import EditMenuComponent.Tier1Menu;
import EditMenuComponent.Edit.*;

import java.awt.event.*;

public class UMLMenuBar extends JMenuBar {
    private static UMLMenuBar umlMenuBar;

    UMLMenuBar() {
        super();
    }

    public static UMLMenuBar gInStance() {
        if (umlMenuBar == null) {
            umlMenuBar = new UMLMenuBar();
        }
        return umlMenuBar;
    }

    public <T extends JMenuItem> void addTier1Menu(Tier1Menu<T> menu) {
        this.add(menu);
    }
}
