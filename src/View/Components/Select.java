package View.Components;

import java.awt.*;
import View.Components.base.*;

public class Select extends EditComponent {

    Point startLoc, endLoc;

    public Select(Container c, Point loc) {
        super(c);
        this.startLoc = loc;
        this.endLoc = loc;
    }

    public void changeSize(Point p) {
        this.endLoc = p;
        container.repaint();
    }

    Rectangle getArea() {
        Point p = this.startLoc;
        if (this.endLoc.x < this.startLoc.x && this.endLoc.y < this.startLoc.y) {
            p = this.endLoc;
        } else if (this.endLoc.x < this.startLoc.x) {
            p = new Point(this.endLoc.x, this.startLoc.y);
        } else if (this.endLoc.y < this.startLoc.y) {
            p = new Point(this.startLoc.x, this.endLoc.y);
        }

        int w = Math.abs(this.endLoc.x - this.startLoc.x);
        int h = Math.abs(this.endLoc.y - this.startLoc.y);

        return new Rectangle(p.x, p.y, w, h);
    }

    public Rectangle getSelectArea() {
        return getArea();
    }

    @Override
    public void draw(Graphics g) {
        Rectangle r = this.getArea();

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.blue);
        g2.fillRect(r.x, r.y, r.width, r.height);
    }

}
