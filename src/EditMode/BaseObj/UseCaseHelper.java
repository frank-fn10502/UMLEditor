package EditMode.BaseObj;

import java.awt.Point;

import EditAreaComponent.BaseObj;
import EditAreaComponent.UseCase;

public class UseCaseHelper implements Helper{

    @Override
    public BaseObj gBaseObj(Point loc) {
        return new UseCase(loc);
    }
    
}
