package View.Components;

import java.awt.*;
import View.Components.base.*;

public class AssociationLine extends Relation {

    public AssociationLine(Container c) {
        super(c);
    }

    @Override
    public void draw(Graphics g) {
        if (!this.visable)
            return;

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.black);
        this.drawArrow(g2);
    }

    void drawArrow(Graphics2D g2) {
        double H = 12;
        double L = 8;
        double awrad = Math.atan(L / H);
        double arraow_len = Math.sqrt(L * L + H * H);
        double[] arrXY_1 = rotateVec(this.end.x - this.start.x, this.end.y - this.start.y, awrad, true, arraow_len);
        double[] arrXY_2 = rotateVec(this.end.x - this.start.x, this.end.y - this.start.y, -awrad, true, arraow_len);
        int x_3 = (int)(this.end.x - arrXY_1[0]);
        int y_3 = (int)(this.end.y - arrXY_1[1]);
        int x_4 = (int)(this.end.x - arrXY_2[0]);
        int y_4 = (int)(this.end.y - arrXY_2[1]);

        g2.drawLine(this.start.x, this.start.y, this.end.x, this.end.y);
        g2.drawLine(this.end.x, this.end.y, x_3, y_3);
        g2.drawLine(this.end.x, this.end.y, x_4, y_4);
    }
}
