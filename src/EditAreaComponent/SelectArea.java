package EditAreaComponent;

import java.awt.*;

public class SelectArea extends EditComponent {

    private Point startLoc;
    private Point endLoc;

    public SelectArea(Point startLoc) {
        super();
        this.startLoc = startLoc;
        this.endLoc = startLoc;
    }

    public void changeArea(Point endLoc) {
        this.endLoc = endLoc;
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

    public Rectangle gSelectArea() {
        return getArea();
    }

    @Override
    public void draw(Graphics g) {
        Rectangle r = this.getArea();

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(18, 70, 86, 30));
        g2.fillRect(r.x, r.y, r.width, r.height);
    }
}
