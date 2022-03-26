package Services.UMLActions;

import Services.EditComponentsService;
import View.Components.AssociationLine;

public class CreateAssociation extends CreateRelation<AssociationLine> {

    public CreateAssociation(EditComponentsService service) {
        super(service);
    }

    @Override
    protected AssociationLine getView() {
        return new AssociationLine(service.gEditArea());
    }
    
}
