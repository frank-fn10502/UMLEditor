package View.Components.base;

import java.awt.*;
import java.util.*;

public class Entity extends EditComponent {
    public interface LocationChangeEventListener extends EventListener {
        void actionPerformed(Entity selectList);
    }

    protected int width, height;
    protected Point location;
    protected UMLContainer parent;

    LocationChangeEventListener eventListener;

    public Entity(Container c, Point loc, int width, int height) {
        super(c);

        this.initLocation(loc, width, height);
        this.parent = null;
    }

    void initLocation(Point loc, int width, int height) {
        this.location = loc;

        this.width = width;
        this.height = height;
    }

    public void changeLocation(int w, int h) {
        this.location.x += w;
        this.location.y += h;

        this.notifyListener();
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Point getLocation() {
        return this.location;
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

    public void addLocationChangeEventListener(LocationChangeEventListener listener) {
        this.eventListener = listener;
    }

    public void removeLocationChangeEventListener() {
        this.eventListener = null;
    }

    public void setParent(UMLContainer parent) {
        this.parent = parent;
    }

    public UMLContainer getParent() {
        return this.parent;
    }

    protected void notifyListener() {
        if (eventListener != null)
            eventListener.actionPerformed(this);
    }
}
