package EditMenuComponent;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class Tier1Menu<T extends JMenuItem> extends JMenu {
    protected String name;
    protected List<T> menuItems;

    public Tier1Menu(String s) {
        super(s);
        menuItems = new ArrayList<T>();
    }

    public void addMenuItem(T munuItem){
        this.add(munuItem);
    }
}
