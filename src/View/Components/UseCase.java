package View.Components;

import java.awt.*;
import View.Components.base.*;

public class UseCase extends BaseObj {

    public UseCase(Container c, Point loc) {
        super(c, loc, 100, 75);
        this.name = "use case";
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        g2.fillOval(this.location.x, this.location.y, this.width, this.height);
        //TODO draw text
    }
}
