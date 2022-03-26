package Services.UMLActions;

import Services.EditComponentsService;
import View.Components.CompositionLine;

public class CreateComposition extends CreateRelation<CompositionLine> {

    public CreateComposition(EditComponentsService service) {
        super(service);
    }

    @Override
    protected CompositionLine getView() {
        return new CompositionLine(service.gEditArea());
    }
    
}
