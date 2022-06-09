package EditMode.ConnectionLine;

import EditAreaComponent.Generation;
import EditAreaComponent.UMLConnectionLine;

public class GenerationHelper implements Helper{

    @Override
    public UMLConnectionLine getConnectionLine() {
        return new Generation();
    }
    
}
