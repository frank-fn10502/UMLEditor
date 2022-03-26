package Controller;

import Services.*;
import View.UMLFrame;
import java.awt.*;
import java.awt.event.*;

public class EditorAreaController {
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

    void setDefaultAction() {
        this.preMethod = this.collection.Select;

        this.frame.sideBar.setCurrentClicked(this.frame.sideBar.btnSelect);
        this.frame.editArea.addMouseListener(this.collection.Select);
        this.frame.editArea.addMouseMotionListener(this.collection.Select);
    }

    // 透過 btn onclick event 更換 Listener 以達到變更 Action 的實作
    void bindButtonClick() {
        this.frame.sideBar.btnSelect.addActionListener(e -> {
            this.addListener(this.frame.editArea, this.collection.Select);
        });
        this.frame.sideBar.btnCreateClass.addActionListener(e -> {
            service.clearSelectList();
            this.addListener(this.frame.editArea, this.collection.CreateClass);
        });
        this.frame.sideBar.btnCreateUseCase.addActionListener(e -> {
            service.clearSelectList();
            this.addListener(this.frame.editArea, this.collection.CreateUseCase);
        });
        this.frame.sideBar.btnAL.addActionListener(e -> {
            service.clearSelectList();
            this.addListener(this.frame.editArea, this.collection.Association);
        });
        this.frame.sideBar.btnGL.addActionListener(e -> {
            service.clearSelectList();
            this.addListener(this.frame.editArea, this.collection.Generalization);
        });
        this.frame.sideBar.btnCL.addActionListener(e -> {
            service.clearSelectList();
            this.addListener(this.frame.editArea, this.collection.Composition);
        });
    }

    void addListener(Container c, MouseAdapter action) {
        if (action == preMethod)
            return;

        c.removeMouseListener(preMethod);
        c.removeMouseMotionListener(preMethod);

        c.addMouseListener(action);
        c.addMouseMotionListener(action);
        preMethod = action;
    }

}
