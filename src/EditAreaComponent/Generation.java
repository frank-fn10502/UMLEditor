package EditAreaComponent;

import java.awt.*;
import java.awt.geom.*;

public class Generation extends UMLConnectionLine{

    @Override
    public void draw(Graphics g) {
        if (!this.visible)
            return;

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.black);
        this.drawArrow(g2);
    }

    private void drawArrow(Graphics2D g2) {
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

        GeneralPath triangle = new GeneralPath();
        triangle.moveTo(this.end.x, this.end.y);
        triangle.lineTo(x_3, y_3);
        triangle.lineTo(x_4, y_4);
        triangle.closePath();
        g2.draw(triangle);
        // g2.fill(triangle);
        g2.drawLine(this.start.x, this.start.y, (int) (x_3 + (x_4 - x_3) / 2), (int) (y_3 + (y_4 - y_3) / 2));
    }

}
