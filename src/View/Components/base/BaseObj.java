package View.Components.base;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BaseObj extends Entity {
    protected class AnchorPoints {
        class Anchor {
            public Point loc;
            public Point attach;

            public Anchor(Point loc, Point attach) {
                this.loc = loc;
                this.attach = attach;
            }
        }

        public boolean visable;
        public int width;

        Anchor north;
        Anchor east;
        Anchor west;
        Anchor south;

        List<Anchor> apList;

        public AnchorPoints(Point loc, int width, int height) {
            this.visable = false;
            this.width = 5;

            this.initPoints(loc, width, height);
        }

        public Point getNorth() {
            return north.loc;
        }

        public Point getEast() {
            return east.loc;
        }

        public Point getWest() {
            return west.loc;
        }

        public Point getSouth() {
            return south.loc;
        }

        public void initPoints(Point loc, int width, int height) {
            int x2 = loc.x + width;
            int y2 = loc.y + height;
            int midX = loc.x + width / 2;
            int midY = loc.y + height / 2;
            int halfW = this.width / 2;

            this.north = new Anchor(new Point(midX - halfW, loc.y - this.width), new Point(midX, loc.y));
            this.east = new Anchor(new Point(x2, midY - halfW), new Point(x2, midY));
            this.south = new Anchor(new Point(midX - halfW, y2), new Point(midX, y2));
            this.west = new Anchor(new Point(loc.x - this.width, midY - halfW), new Point(loc.x, midY));

            this.apList = new ArrayList<Anchor>();
            apList.add(this.north);
            apList.add(this.east);
            apList.add(this.south);
            apList.add(this.west);

        }

        public Point getNearestAnchorPoint(Point p) {
            Point minDistPoint = null;
            int minDist = 10000;
            for (Anchor a : apList) {
                int dist = Math.abs(p.x - a.attach.x) + Math.abs(p.y - a.attach.y);
                if (dist < minDist) {
                    minDist = dist;
                    minDistPoint = a.attach;
                }
            }
            return minDistPoint;
        }

        public void changePosition(int w, int h) {
            for (Anchor anchor : apList) {
                anchor.loc.x += w;
                anchor.loc.y += h;
                anchor.attach.x += w;
                anchor.attach.y += h;
            }
        }
    }

    protected AnchorPoints aps;
    protected String name;

    public BaseObj(Container c, Point loc) {
        this(c, loc, 75, 100);
    }

    public BaseObj(Container c, Point loc, int width, int height) {
        super(c, loc, width, height);

        this.aps = new AnchorPoints(loc, width, height);
        this.name = "baseObj";
        this.depth = 90;
    }

    protected void drawAnchors(Graphics g) {
        if (!this.aps.visable)
            return;
        int w = this.aps.width;

        g.setColor(Color.black);
        g.fillRect(this.aps.getNorth().x, this.aps.getNorth().y, w, w);
        g.fillRect(this.aps.getEast().x, this.aps.getEast().y, w, w);
        g.fillRect(this.aps.getSouth().x, this.aps.getSouth().y, w, w);
        g.fillRect(this.aps.getWest().x, this.aps.getWest().y, w, w);
    }

    @Override
    public void draw(Graphics g) {
        this.drawAnchors(g);
    }

    public void showAnchorPoints(boolean show) {
        this.aps.visable = show;
        container.repaint();
    }

    @Override
    public void changeLocation(int w, int h) {
        super.changeLocation(w, h);
        this.aps.changePosition(w, h);
        container.repaint();
    }

    public void setName(String name) {
        this.name = name;
        container.repaint();
    }

    public Point getNearestAnchorPoint(Point p) {
        return this.aps.getNearestAnchorPoint(p);
    }

    protected void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java
        // 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        g.setFont(font);
        // Draw the String
        g.drawString(text, x, y);
    }
}
