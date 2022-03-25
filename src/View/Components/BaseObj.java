package View.Components;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BaseObj extends EditComponent {
    protected class AnchorPoints {
        public boolean visable;
        public int width;

        Point north;
        Point east;
        Point west;
        Point south;
        List<Point> aps;

        public AnchorPoints(Point loc, int width, int height) {
            this.visable = false;
            this.width = 10;

            this.initPoints(loc, width, height);
        }

        public Point getNorth() {
            return north;
        }

        public Point getEast() {
            return east;
        }

        public Point getWest() {
            return west;
        }

        public Point getSouth() {
            return south;
        }

        public void initPoints(Point loc, int width, int height) {
            int x2 = loc.x + width;
            int y2 = loc.y + height;
            int midX = loc.x + width / 2;
            int midY = loc.y + height / 2;
            int halfW = this.width / 2;

            this.north = new Point(midX - halfW, loc.y - this.width);
            this.east = new Point(x2, midY - halfW);
            this.south = new Point(midX - halfW, y2);
            this.west = new Point(loc.x - this.width, midY - halfW);

            this.aps = new ArrayList<Point>();
            aps.add(this.north);
            aps.add(this.east);
            aps.add(this.south);
            aps.add(this.west);

        }

        public Point getNearestAnchorPoint(Point p) {
            Point minDistPoint = null;
            int minDist = 10000;
            for (Point point : aps) {
                int dist = Math.abs(p.x - point.x) + Math.abs(p.y - point.y);
                if (dist < minDist) {
                    minDist = dist;
                    minDistPoint = point;
                }
            }
            return minDistPoint;
        }

        public void changePosition(int w, int h) {
            for (Point point : aps) {
                point.x += w;
                point.y += h;
            }
        }
    }

    protected AnchorPoints aps;
    protected Point location;

    protected int width, height;

    public BaseObj(Container c, Point loc) {
        this(c, loc, 75, 100);
    }

    public BaseObj(Container c, Point loc, int width, int height) {
        super(c);

        this.initLocation(loc, width, height);
    }

    void initLocation(Point loc, int width, int height) {
        this.location = loc;

        this.width = width;
        this.height = height;

        this.aps = new AnchorPoints(loc, width, height);
    }

    protected void setAnchors(Graphics g) {
        if (!this.aps.visable)
            return;
        int w = this.aps.width;

        g.setColor(Color.green);
        g.fillRect(this.aps.getNorth().x, this.aps.getNorth().y, w, w);
        g.fillRect(this.aps.getEast().x, this.aps.getEast().y, w, w);
        g.fillRect(this.aps.getSouth().x, this.aps.getSouth().y, w, w);
        g.fillRect(this.aps.getWest().x, this.aps.getWest().y, w, w);
    }

    @Override
    public void draw(Graphics g) {
        this.setAnchors(g);
    }

    public void showAnchorPoints(boolean show) {
        this.aps.visable = show;
        container.repaint();
    }

    public void changeLocation(Point newLoc) {
        int w = newLoc.x - this.location.x;
        int h = newLoc.y - this.location.y;

        this.location = newLoc;
        this.aps.changePosition(w, h);
        container.repaint();
    }

    public Point getNearestAnchorPoint(Point p) {
        return this.aps.getNearestAnchorPoint(p);
    }

    public boolean isInteract(Point p) {
        int x1 = this.location.x;
        int x2 = this.location.x + this.width;
        int y1 = this.location.y;
        int y2 = this.location.y + this.height;

        if (p.x <= x2 && p.x >= x1 &&
                p.y <= y2 && p.y >= y1) {
            return true;
        }
        return false;
    }

    public boolean isInteract(Rectangle rect) {
        int x1 = this.location.x;
        int x2 = this.location.x + this.width;
        int y1 = this.location.y;
        int y2 = this.location.y + this.height;

        int w = 0, h = 0;
        w = Math.min(x2, rect.x + rect.width) - Math.max(x1, rect.x);
        h = Math.min(y2, rect.y + rect.height) - Math.max(y1, rect.y);

        if (w < 0 || h < 0)
            return false;

        return true;
    }
}
