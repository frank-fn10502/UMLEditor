package View.Components;

import java.awt.*;

public class UMLClass extends BaseObj {

    public UMLClass(Container c, Point loc) {
        super(c, loc);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        g2.fillRect(this.location.x, this.location.y, this.width, this.height);
    }
}
