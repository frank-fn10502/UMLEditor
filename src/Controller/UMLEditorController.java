package Controller;

import Services.*;
import Test.Listeners.EditAreaMouseListener;
import UMLActions.*;
import View.UMLFrame;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

public class UMLEditorController {

    class ListenerHelper {
        public void addListener(Container c, MouseAdapter method) {
            if (method == preMethod)
                return;

            c.removeMouseListener(preMethod);
            c.addMouseListener(method);
        }
    }

    UMLFrame frame;
    ActionsServices collection;
    MouseAdapter preMethod;

    public UMLEditorController(UMLFrame frame, ActionsServices collection) {
        super();
        this.frame = frame;
        this.collection = collection;
        this.preMethod = collection.Select;

        // this.frame.editArea.addMouseListener(new EditAreaMouseListener());
        // this.frame.editArea.addMouseMotionListener(new EditAreaMouseListener());

        // temp
        // this.frame.editArea.addMouseListener(new CreateClass(service));
        // this.frame.editArea.addMouseListener(new CreateUseCase(service));
        bindButtonClick();
    }

    // 透過 btn onclick event 更換 Listener 以達到變更 Action 的實作
    void bindButtonClick() {
        // frame.btnSelect.addActionListener(e -> {
        // this.frame.editArea.addMouseListener(collection.Select);
        // });
        frame.btnCreateClass.addActionListener(e -> {
            new ListenerHelper().addListener(this.frame, collection.CreateClass);
        });
        frame.btnCreateUseCase.addActionListener(e -> {
            new ListenerHelper().addListener(this.frame, collection.CreateUseCase);
        });
    }

}
