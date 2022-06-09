package EditAreaComponent;

import java.awt.Point;
import java.awt.*;

public class UseCase extends BaseObj{

    public UseCase(Point location) {
        super(location, 100, 75, "use case");
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.black);
        g2.drawOval(this.location.x, this.location.y, this.width, this.height);
        g2.setColor(Color.gray);
        g2.fillOval(this.location.x, this.location.y, this.width, this.height);

        Font f = g2.getFont().deriveFont(12.0f);
        Rectangle textArea = new Rectangle(this.location.x, this.location.y, this.width, this.height);
        g2.setFont(f);
        g2.setColor(Color.black);
        this.drawCenteredString(g2, this.name, textArea, f);
    }
    
}
