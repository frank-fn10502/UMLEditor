package EditMode.Listener;

import java.util.ArrayList;
import java.util.List;

import EditAreaComponent.UMLObject;

public interface SelectListener {
    void selectChanged(List<UMLObject> umlObjs);
}
