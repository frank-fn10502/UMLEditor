package EditAreaComponent;

import java.awt.*;

public class UMLConnectionLine extends EditComponent {
    protected Point start;
    protected Point end;

    public UMLConnectionLine() {
        super();
        this.depth = 0;
    }

    public void setStartPoint(Point p) {
        this.start = p;
    }

    public void changeEndPoint(Point p) {
        this.end = p;
        this.editArea.repaint();
    }

    protected double[] rotateVec(double e, double f, double ang, boolean isChLen, double newLen) {
        double mathstr[] = new double[2];
        double vx = e * Math.cos(ang) - f * Math.sin(ang);
        double vy = e * Math.sin(ang) + f * Math.cos(ang);
        if (isChLen) {
            double d = Math.sqrt(vx * vx + vy * vy);
            vx = vx / d * newLen;
            vy = vy / d * newLen;
            mathstr[0] = vx;
            mathstr[1] = vy;
        }
        return mathstr;
    }
}