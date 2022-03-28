package View.Components.base;

import java.awt.*;
import java.util.List;

public class UMLContainer extends Entity {
    protected List<Entity> entityList;

    public UMLContainer(Container c, Point loc, int width, int height) {
        super(c, loc, width, height);

        this.depth = 80;
    }

    public void show(boolean show) {
    }

    public List<Entity> getEntityList() {
        return this.entityList;
    }

    @Override
    public void changeLocation(int w, int h) {
        for (Entity entity : entityList) {
            entity.changeLocation(w, h);
        }
    }
}
