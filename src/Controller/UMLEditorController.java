package Controller;

import Services.*;
import Test.Listeners.EditAreaMouseListener;
import UMLActions.*;
import View.UMLFrame;
import java.awt.*;

public class UMLEditorController {

    private UMLFrame frame;
    private ActionsServices collection;

    public UMLEditorController(UMLFrame frame, ActionsServices collection) {
        super();
        this.frame = frame;
        this.collection = collection;

        // this.frame.editArea.addMouseListener(new EditAreaMouseListener());
        // this.frame.editArea.addMouseMotionListener(new EditAreaMouseListener());

        // temp
        // this.frame.editArea.addMouseListener(new CreateClass(service));
        // this.frame.editArea.addMouseListener(new CreateUseCase(service));
    }

    // 透過 btn onclick event 更換 Listener 以達到變更 Action 的實作
}
