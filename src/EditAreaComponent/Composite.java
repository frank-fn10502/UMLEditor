package EditAreaComponent;

import java.awt.*;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Composite extends UMLObject {

    List<UMLObject> umlObjs;
    int padding;

    public Composite(List<UMLObject> umlObjs) {
        super(new Point(), 0, 0);
        this.umlObjs = umlObjs;
        this.visible = true;
        this.padding = 10;
        this.depth = 1;
        this.calBounds();
    }

    @Override
    public void moveDirection(int x, int y) {
        for (UMLObject umlObject : umlObjs) {
            umlObject.moveDirection(x, y);
        }
    }

    @Override
    public void addUmLObj(UMLObject obj) {
        this.umlObjs.add(obj);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        if (!this.visible)
            return;

        Rectangle b = this.getBounds();

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.CYAN);
        g2.drawRect(b.x, b.y, b.width, b.height);

        for (UMLObject umlObject : umlObjs) {
            umlObject.draw(g);
        }
    }

    @Override
    public List<UMLObject> getAllChilds() {
        return this.umlObjs;
    }

    @Override
    public UMLObject removeUmLObj(UMLObject obj) {
        this.umlObjs.remove(obj);
        return obj;
    }

    @Override
    public void select(boolean isSelected) {
        super.select(isSelected);
        for (UMLObject umlObject : umlObjs) {
            umlObject.select(isSelected);
        }
    }

    void calBounds() {
        Point start = new Point(this.umlObjs.get(0).getLocation());
        Point end = new Point(this.umlObjs.get(0).getLocation());
        for (UMLObject umlObject : umlObjs) {
            Point c = umlObject.getLocation();// curret

            if (start.x > c.x) {
                start.x = c.x;
            }
            if (start.y > c.y) {
                start.y = c.y;
            }
            if (end.x < c.x + umlObject.getWidth()) {
                end.x = c.x + umlObject.getWidth();
            }
            if (end.y < c.y + umlObject.getHeight()) {
                end.y = c.y + umlObject.getHeight();
            }
        }
        this.location = new Point(start.x - this.padding, start.y - this.padding);
        this.width = end.x - start.x + this.padding * 2;
        this.height = end.y - start.y + this.padding * 2;
    }

    Rectangle getBounds() {
        this.calBounds();
        return new Rectangle(this.location.x, this.location.y, this.width, this.height);
    }

}
