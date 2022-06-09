package EditMode.ConnectionLine;

import EditAreaComponent.Association;
import EditAreaComponent.UMLConnectionLine;

public class AssociationHelper implements Helper{

    @Override
    public UMLConnectionLine getConnectionLine() {
        return new Association();
    }
}
