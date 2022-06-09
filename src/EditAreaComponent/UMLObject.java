package EditAreaComponent;

import java.awt.*;

public abstract class UMLObject extends EditComponent{
    protected int width;
    protected int height;

    Point location;

    public UMLObject(Point location, int width, int height) {
        this.width = width;
        this.height = height;
        this.location = location;
        this.visible = true;
    }

    @Override
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

    @Override
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
    @Override
    public void moveDirection(int x, int y) {
        this.location.x += x;
        this.location.y += y;
    }

    public Point getLocation(){
        return this.location;
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
}
