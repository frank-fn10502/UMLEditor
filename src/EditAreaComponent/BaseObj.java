package EditAreaComponent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseObj extends UMLObject {
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

        public void moveDirection(int w, int h) {
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

    public BaseObj(Point location, int width, int height, String name) {
        super(location, width, height);

        this.name = name;
        this.aps = new AnchorPoints(location, width, height);
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

    public void changeName(String name) {
        this.name = name;
        this.editArea.repaint();
    }

    public Point getNearestPoint(Point p) {
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

    @Override
    public void draw(Graphics g) {
        this.drawAnchors(g);
    }

    @Override
    public void select(boolean isSelected) {
        super.select(isSelected);
        this.aps.visable = isSelected;
        this.editArea.repaint();
    }

    @Override
    public void moveDirection(int x, int y) {
        super.moveDirection(x, y);
        this.aps.moveDirection(x, y);
        this.editArea.repaint();
    }
}
