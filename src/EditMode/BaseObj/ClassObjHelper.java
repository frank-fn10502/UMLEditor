package EditMode.BaseObj;

import java.awt.Point;

import EditAreaComponent.BaseObj;
import EditAreaComponent.UMLClass;

public class ClassObjHelper implements Helper{

    @Override
    public BaseObj gBaseObj(Point loc) {
        return new UMLClass(loc);
    }
    
}
