import Controller.UMLEditorController;
import Services.EditComponentsService;
import View.*;

public class App {
    public static void main(String[] args) throws Exception {
        UMLFrame frame = new UMLFrame();
        EditComponentsService service = new EditComponentsService(frame.editArea);
        
        UMLEditorController controller = new UMLEditorController(frame, service);
    }
}
