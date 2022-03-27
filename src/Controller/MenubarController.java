package Controller;

import java.util.ArrayList;
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
    UMLContainer root;
    List<Entity> entityList;
    // Composite view;

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
        List<UMLContainer> containerList = new ArrayList<UMLContainer>();
        for (BaseObj item : list) {
            if (item.getParent() == null) {
                return false;
            } else {
                this.root = this.findRootParent(item);
                containerList.add(this.root);
            }
        }
        return containerList.size() == 1 ? true : false;
    }

    void setContainerList(List<BaseObj> list) {
        this.containerList = new ArrayList<UMLContainer>();
        this.entityList = new ArrayList<Entity>();
        for (BaseObj item : list) {
            if (item.getParent() == null) {
                this.entityList.add(item);
            } else {
                UMLContainer root = this.addParentUntilRoot(item);
                this.entityList.add(root);
                this.addChiledComposite(root);
            }
        }
    }

    UMLContainer findRootParent(BaseObj item) {
        UMLContainer root = null;
        for (UMLContainer p = item.getParent(); p != null; p = p.getParent()) {
            if (!this.containerList.contains(p.getParent())) {
                root = p;
            }
        }
        return root;
    }

    UMLContainer addParentUntilRoot(BaseObj item) {
        UMLContainer root = this.findRootParent(item);
        this.containerList.add(root);
        return root;
    }

    void addChiledComposite(UMLContainer c) {
        for (Entity item : ((Composite) c).getEntityList()) {
            if (item instanceof Composite) {
                this.containerList.add((Composite) item);
            }
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
                UMLContainer c = new Composite(service.gEditArea(), this.entityList);
                this.service.addComponent(c);

                this.containerList.add(c);
                this.menubar.EnabledMethodUnGroupObj(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        this.menubar.setUnGroupObjListener(e -> {
            this.service.removeComponent(this.root);
            this.containerList.remove(this.root);
            this.root = this.containerList.size() == 1 ? this.containerList.get(0) : null;
            this.menubar.EnabledMethodUnGroupObj(this.root != null);
        });
    }
}
