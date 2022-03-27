package View.Components.base;

import java.awt.*;

public class Relation extends EditComponent {
    protected Point start;
    protected Point end;
    protected boolean visable;

    public Relation(Container c) {
        super(c);
        visable = false;
        this.depth = 98;
    }

    public void setStartPoint(Point p) {
        this.start = p;
        container.repaint();
    }

    public void setEndPoint(Point p) {
        this.end = p;
        container.repaint();
    }

    public void show(boolean show) {
        this.visable = show;
        container.repaint();
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
