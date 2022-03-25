import Controller.UMLEditorController;
import Services.*;
import UMLActions.*;
import View.*;

public class App {
    public static void main(String[] args) throws Exception {
        UMLFrame frame = new UMLFrame();
        EditComponentsService ECservice = new EditComponentsService(frame.editArea);
        
        ActionsServices actionCollection = new ActionsServices();
        actionCollection.Select = new Select(ECservice);
        actionCollection.CreateClass = new CreateClass(ECservice);
        actionCollection.CreateUseCase = new CreateUseCase(ECservice);

        new UMLEditorController(frame, actionCollection, ECservice);
    }
}
