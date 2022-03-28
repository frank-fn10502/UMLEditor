package View.Components;

import java.awt.*;
import java.util.List;
import View.Components.base.Entity;
import View.Components.base.UMLContainer;

public class Composite extends UMLContainer {

    boolean visable;
    int padding;

    public Composite(Container c, List<Entity> entityList) throws Exception {
        super(c, new Point(), 0, 0);

        this.padding = 10;
        this.visable = true;
        this.setEntityList(entityList);
        this.calBounds();
    }

    void setEntityList(List<Entity> entityList) throws Exception {
        if (entityList.size() < 2) {
            if (entityList.size() == 1 && entityList.get(0) instanceof Composite) {

            } else
                throw new Exception("Composite need more than 2 baseObj");
        }
        this.entityList = entityList;
        for (Entity entity : this.entityList) {
            entity.addLocationChangeEventListener(e -> {
                this.calBounds();
            });
            entity.setParent(this);
        }
    }

    void calBounds() {
        Point start = new Point(entityList.get(0).getLocation());
        Point end = new Point(entityList.get(0).getLocation());
        for (Entity entity : entityList) {
            Point c = entity.getLocation();// curret

            if (start.x > c.x) {
                start.x = c.x;
            }
            if (start.y > c.y) {
                start.y = c.y;
            }
            if (end.x < c.x + entity.getWidth()) {
                end.x = c.x + entity.getWidth();
            }
            if (end.y < c.y + entity.getHeight()) {
                end.y = c.y + entity.getHeight();
            }
        }
        this.location = new Point(start.x - this.padding, start.y - this.padding);
        this.width = end.x - start.x + this.padding * 2;
        this.height = end.y - start.y + this.padding * 2;

        this.notifyListener();
    }

    Rectangle getBounds() {
        return new Rectangle(this.location.x, this.location.y, this.width, this.height);
    }

    @Override
    public void show(boolean show) {
        this.visable = show;
        this.container.repaint();
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        if (!this.visable)
            return;

        Rectangle b = this.getBounds();

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.CYAN);
        g2.drawRect(b.x, b.y, b.width, b.height);
    }

    @Override
    public void destoryEntity() {
        super.destoryEntity();
        for (Entity entity : this.entityList) {
            entity.removeLocationChangeEventListener();
            entity.setParent(null);
        }
    }
}
