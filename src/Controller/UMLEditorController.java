package Controller;

import Services.*;
import Test.Listeners.EditAreaMouseListener;
import View.UMLFrame;
import java.awt.*;
import java.awt.event.*;

public class UMLEditorController {

    class ListenerHelper {
        public void addListener(Container c, MouseAdapter action) {
            if (action == preMethod)
                return;

            c.removeMouseListener(preMethod);
            c.removeMouseMotionListener(preMethod);

            c.addMouseListener(action);
            c.addMouseMotionListener(action);
            preMethod = action;
        }
    }

    UMLFrame frame;
    ActionsServices collection;
    MouseAdapter preMethod;
    EditComponentsService service;

    public UMLEditorController(UMLFrame frame, ActionsServices collection, EditComponentsService service) {
        super();
        this.frame = frame;
        this.collection = collection;
        this.service = service;
        this.preMethod = collection.Select;

        this.frame.editArea.addMouseListener(collection.Select);
        this.frame.editArea.addMouseMotionListener(collection.Select);

        bindButtonClick();
    }

    // 透過 btn onclick event 更換 Listener 以達到變更 Action 的實作
    void bindButtonClick() {
        frame.btnSelect.addActionListener(e -> {
            new ListenerHelper().addListener(this.frame.editArea, collection.Select);
        });
        frame.btnCreateClass.addActionListener(e -> {
            service.clearSelectList();
            new ListenerHelper().addListener(this.frame.editArea, collection.CreateClass);
        });
        frame.btnCreateUseCase.addActionListener(e -> {
            service.clearSelectList();
            new ListenerHelper().addListener(this.frame.editArea, collection.CreateUseCase);
        });
    }

}
