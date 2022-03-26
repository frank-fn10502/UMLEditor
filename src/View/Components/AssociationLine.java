package View.Components;

import java.awt.*;

public class AssociationLine extends Relation {

    public AssociationLine(Container c) {
        super(c);
    }

    @Override
    public void draw(Graphics g) {
        if (!this.visable)
            return;

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g.setColor(Color.orange);
        g.drawLine(this.start.x, this.start.y, this.end.x, this.end.y);
    }
}
