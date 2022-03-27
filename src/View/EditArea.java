package View;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import View.Components.base.*;
import java.awt.*;

/**
 * 需要新增&刪除 EditComponent, 且需要將 EditComponent 所需圖示畫出來。
 */
public class EditArea extends JPanel {
    List<EditComponent> ecList;

    public EditArea(Rectangle loc_size) {
        super();

        setJpanelValue(loc_size);

        ecList = new ArrayList<EditComponent>();
    }

    public void addEditComponent(EditComponent ec) {
        ecList.add(ec);
        ecList.sort((i1, i2) -> i2.getDepth() - i1.getDepth());
        this.repaint();
    }

    public void removeEditComponent(EditComponent ec) {
        ecList.remove(ec);
        this.repaint();
    }

    public void sortComponent(){
        ecList.sort((i1, i2) -> i2.getDepth() - i1.getDepth());
        this.repaint();
    }

    void setJpanelValue(Rectangle loc_size) {
        this.setBounds(loc_size);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (EditComponent ec : ecList) {
            ec.draw(g);
        }
    }
}
