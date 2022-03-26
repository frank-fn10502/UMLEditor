import Controller.UMLEditorController;
import Services.*;
import Services.UMLActions.*;
import View.*;

public class App {
    public static void main(String[] args) throws Exception {
        UMLFrame frame = new UMLFrame();
        EditComponentsService ECservice = new EditComponentsService(frame.editArea);
        
        ActionsServices actionCollection = new ActionsServices();
        actionCollection.Select = new Select(ECservice);
        actionCollection.CreateClass = new CreateClass(ECservice);
        actionCollection.CreateUseCase = new CreateUseCase(ECservice);
        actionCollection.Association = new CreateAssociation(ECservice);
        actionCollection.Generalization = new CreateGeneralization(ECservice);
        actionCollection.Composition = new CreateComposition(ECservice);

        new UMLEditorController(frame, actionCollection, ECservice);
    }
}
