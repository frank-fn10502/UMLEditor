package View.Components;

import java.awt.*;
import View.Components.base.*;

public class CompositionLine extends Relation {

    public CompositionLine(Container c) {
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

    private void drawArrow(Graphics2D g2) {
        double H = 10;
        double L = 6;
        double awrad = Math.atan(L / H);
        double arraow_len = Math.sqrt(L * L + H * H);
        double[] arrXY_1 = rotateVec(this.end.x - this.start.x, this.end.y - this.start.y, awrad, true, arraow_len);
        double[] arrXY_2 = rotateVec(this.end.x - this.start.x, this.end.y - this.start.y, -awrad, true, arraow_len);
        int x_3 = (int) (this.end.x - arrXY_1[0]);
        int y_3 = (int) (this.end.y - arrXY_1[1]);
        int x_4 = (int) (this.end.x - arrXY_2[0]);
        int y_4 = (int) (this.end.y - arrXY_2[1]);

        double x_5 = x_3 + (x_4 - x_3) / 2;
        double y_5 = y_3 + (y_4 - y_3) / 2;
        double x_6 = this.end.x - (this.end.x - x_5) * 2;
        double y_6 = this.end.y - (this.end.y - y_5) * 2;

        g2.drawLine(this.start.x, this.start.y, (int) x_6, (int) y_6);
        g2.drawLine(this.end.x, this.end.y, (int) x_3, (int) y_3);
        g2.drawLine(this.end.x, this.end.y, (int) x_4, (int) y_4);
        g2.drawLine((int) x_6, (int) y_6, (int) x_3, (int) y_3);
        g2.drawLine((int) x_6, (int) y_6, (int) x_4, (int) y_4);
    }
}
