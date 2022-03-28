package Controller;

import java.lang.instrument.ClassFileTransformer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import Services.EditComponentsService;
import View.UMLMenuBar;
import View.Components.Composite;
import View.Components.base.*;

public class MenubarController {
    UMLMenuBar menubar;
    EditComponentsService service;
    List<UMLContainer> containerList;
    List<UMLContainer> topContainerList;
    UMLContainer root;
    List<BaseObj> baseObjList;

    public MenubarController(UMLMenuBar menubar, EditComponentsService service) {
        this.menubar = menubar;
        this.service = service;
        this.containerList = new ArrayList<UMLContainer>();

        this.service.addSelectEventListener(e -> {
            this.containerList.forEach(item -> {
                item.show(false);
            });

            this.setContainerList(e);

            boolean only_one = e.size() == 1;
            boolean more_than_two = e.size() >= 2;
            boolean have_container = this.containerList.size() > 0;
            boolean onlyOneRootGroup = this.onlyOneCompositeContains(e);

            this.menubar.EnabledMethodGroup(more_than_two);
            this.menubar.EnabledMethodUnGroupObj(onlyOneRootGroup && have_container);
            this.menubar.EnabledMethodChangeObjName(only_one);

            this.containerList.forEach(item -> {
                item.show(true);
            });
        });
        this.bindListener();
    }

    boolean onlyOneCompositeContains(List<BaseObj> list) {
        this.topContainerList = new ArrayList<UMLContainer>();
        for (BaseObj item : list) {
            if (item.getParent() == null) {
                return false;
            } else {
                UMLContainer root = this.findRootParent(item);
                if (root != null && !this.topContainerList.contains(root)) {
                    this.topContainerList.add(root);
                }

            }
        }
        return this.topContainerList.size() == 1 ? true : false;
    }

    void setContainerList(List<BaseObj> list) {
        this.containerList = new ArrayList<UMLContainer>();
        this.topContainerList = new ArrayList<UMLContainer>();
        this.baseObjList = new ArrayList<BaseObj>();
        for (BaseObj item : list) {
            if (item.getParent() == null) {
                this.baseObjList.add(item);
            } else {
                this.addUtilRoot(item);
            }
        }
    }

    UMLContainer findRootParent(BaseObj item) {
        UMLContainer root = null;
        for (UMLContainer p = item.getParent(); p != null; p = p.getParent()) {
            root = p;
        }
        return root;
    }

    void addUtilRoot(BaseObj item) {
        UMLContainer root = null;
        for (UMLContainer p = item.getParent(); p != null; p = p.getParent()) {
            if (!this.containerList.contains(p)) {
                this.containerList.add(p);
            }
            root = p;
        }
        if (!this.topContainerList.contains(root)) {
            this.topContainerList.add(root);
        }
    }

    void bindListener() {
        this.menubar.setChangeObjNameListener(e -> {
            List<BaseObj> sList = service.getSelectList();
            String name = JOptionPane.showInputDialog("enter the name: ");
            if (name != null && !name.isEmpty()) {
                sList.get(0).setName(name);
            }
        });
        this.menubar.setGroupListener(e -> {
            try {
                List<Entity> allEntity = new ArrayList<>();
                allEntity.addAll(this.topContainerList);
                allEntity.addAll(this.baseObjList);

                UMLContainer c = new Composite(service.gEditArea(), allEntity);
                this.service.addComponent(c);

                this.containerList.add(c);
                this.menubar.EnabledMethodUnGroupObj(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        this.menubar.setUnGroupObjListener(e -> {
            this.root = this.topContainerList.get(0);
            this.service.removeComponent(this.root);
            this.containerList.remove(this.root);

            List<UMLContainer> secContainerList = this.finAllSecendContainer(this.root);
            this.root = secContainerList.size() == 1 ? this.containerList.get(0) : null;
            this.menubar.EnabledMethodUnGroupObj(this.root != null);
        });
    }

    List<UMLContainer> finAllSecendContainer(UMLContainer c) {
        List<UMLContainer> cList = new ArrayList<>();
        for (Entity entity : c.getEntityList()) {
            if (entity instanceof UMLContainer) {
                cList.add((UMLContainer) entity);
            }
        }
        return cList;
    }
}
