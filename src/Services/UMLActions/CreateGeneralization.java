package Services.UMLActions;

import Services.EditComponentsService;
import View.Components.GeneralizationLine;

public class CreateGeneralization extends CreateRelation<GeneralizationLine> {

    public CreateGeneralization(EditComponentsService service) {
        super(service);
    }

    @Override
    protected GeneralizationLine getView() {
        return new GeneralizationLine(service.gEditArea());
    }
    
}
