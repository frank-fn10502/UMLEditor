package Controller;

import Services.*;
import View.UMLFrame;
import java.awt.*;
import java.awt.event.*;

public class EditorAreaController {

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

    public EditorAreaController(UMLFrame frame, ActionsServices collection, EditComponentsService service) {
        super();
        this.frame = frame;
        this.collection = collection;
        this.service = service;

        setDefaultAction();
        bindButtonClick();
    }
    void setDefaultAction(){
        this.preMethod = collection.Select;

        this.frame.sideBar.setCurrentClicked(this.frame.sideBar.btnSelect);
        this.frame.editArea.addMouseListener(collection.Select);
        this.frame.editArea.addMouseMotionListener(collection.Select);
    }

    // 透過 btn onclick event 更換 Listener 以達到變更 Action 的實作
    void bindButtonClick() {
        this.frame.sideBar.btnSelect.addActionListener(e -> {
            new ListenerHelper().addListener(this.frame.editArea, collection.Select);
        });
        this.frame.sideBar.btnCreateClass.addActionListener(e -> {
            service.clearSelectList();
            new ListenerHelper().addListener(this.frame.editArea, collection.CreateClass);
        });
        this.frame.sideBar.btnCreateUseCase.addActionListener(e -> {
            service.clearSelectList();
            new ListenerHelper().addListener(this.frame.editArea, collection.CreateUseCase);
        });
        this.frame.sideBar.btnAL.addActionListener(e -> {
            service.clearSelectList();
            new ListenerHelper().addListener(this.frame.editArea, collection.Association);
        });
        this.frame.sideBar.btnGL.addActionListener(e -> {
            service.clearSelectList();
            new ListenerHelper().addListener(this.frame.editArea, collection.Generalization);
        });
        this.frame.sideBar.btnCL.addActionListener(e -> {
            service.clearSelectList();
            new ListenerHelper().addListener(this.frame.editArea, collection.Composition);
        });
    }

}
