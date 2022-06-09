package EditAreaComponent;

import java.awt.*;
import java.awt.Point;

public class UMLClass extends BaseObj{

    public UMLClass(Point location) {
        super(location, 75, 100, "class");
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.black);
        g2.drawRect(this.location.x, this.location.y, this.width, this.height);
        g2.setColor(Color.gray);
        g2.fillRect(this.location.x, this.location.y, this.width, this.height);

        int x1 = this.location.x;
        int x2 = this.location.x + this.width;
        int yGap = this.height / 3;
        g2.setColor(Color.black);
        g2.drawLine(x1, this.location.y + yGap, x2, this.location.y + yGap);
        g2.drawLine(x1, this.location.y + yGap * 2, x2, this.location.y + yGap * 2);

        Font f = g2.getFont().deriveFont(12.0f);
        Rectangle textArea = new Rectangle(this.location.x, this.location.y, this.width, this.height / 3);
        g2.setFont(f);
        g2.setColor(Color.black);
        this.drawCenteredString(g2, this.name, textArea, f);
    }
    
}
