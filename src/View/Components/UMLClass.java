package View.Components;

import java.awt.*;
import View.Components.base.*;

public class UMLClass extends BaseObj {

    public UMLClass(Container c, Point loc) {
        super(c, loc);

        this.name = "class";
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.draw(this.location.x, this.location.y, this.width, this.height);
        g2.setColor(Color.gray);
        g2.fillRect(this.location.x, this.location.y, this.width, this.height);
        
        //TODO draw text
        g2.setColor(Color.black);
        g2.drawString(this.name, this.location.x, this.location.y);
    }
}
