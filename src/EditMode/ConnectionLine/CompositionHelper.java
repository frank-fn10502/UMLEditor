package EditMode.ConnectionLine;

import EditAreaComponent.Composition;
import EditAreaComponent.UMLConnectionLine;

public class CompositionHelper implements Helper{

    @Override
    public UMLConnectionLine getConnectionLine() {
        return new Composition();
    }
    
}
