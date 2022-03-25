package View;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import View.Components.*;
import java.awt.*;

/**
 * 需要新增&刪除 EditComponent, 且需要將 EditComponent 所需圖示畫出來。
 */
public class EditArea extends JPanel {
    List<EditComponent> ecList;

    public EditArea() {
        super();
        ecList = new ArrayList<EditComponent>();
    }

    public void addEditComponent(EditComponent ec) {
        ecList.add(ec);
    }

    public void removeEditComponent(EditComponent ec) {
        ecList.remove(ec);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (EditComponent ec : ecList) {
            ec.draw(g);
        }
    }
}
