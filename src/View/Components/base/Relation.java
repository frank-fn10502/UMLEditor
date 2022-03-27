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
    public void setStartPoint(Point p){
        this.start = p;
        container.repaint();
    }
    public void setEndPoint(Point p){
        this.end = p;
        container.repaint();
    }
    public void show(boolean show){
        this.visable = show;
        container.repaint();
    }
    
}
