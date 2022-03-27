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
    List<Entity> entityList;
    Composite view;

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
            boolean onlyGroup = this.noCompositeContains(e);

            this.menubar.EnabledMethodGroup(more_than_two);
            this.menubar.EnabledMethodUnGroupObj(onlyGroup && have_container);
            this.menubar.EnabledMethodChangeObjName(only_one);

            this.containerList.forEach(item -> {
                item.show(true);
            });
        });
        this.bindListener();
    }

    boolean noCompositeContains(List<BaseObj> list){
        for (BaseObj baseObj : list) {
            if(baseObj.getParent() == null){
                return false;
            }
        }
        return true;
    }

    void setContainerList(List<BaseObj> list) {
        this.containerList = new ArrayList<UMLContainer>();
        this.entityList = new ArrayList<Entity>();
        for (BaseObj item : list) {
            if (item.getParent() == null) {
                this.entityList.add(item);
            } else if (item.getParent() != null) {
                UMLContainer root = this.addParentUntilRoot(item);
                this.entityList.add(root);
                this.addChiledComposite(root);
            }
        }
    }

    UMLContainer addParentUntilRoot(BaseObj item) {
        UMLContainer root = null;
        for (UMLContainer p = item.getParent(); p != null; p = p.getParent()) {
            if (!this.containerList.contains(p.getParent())) {
                this.containerList.add(p);
                root = p;
            }
        }
        return root;
    }

    void addChiledComposite(UMLContainer c) {
        for (Entity item : ((Composite) c).getEntityList()) {
            if (item instanceof Composite) {
                this.containerList.add((Composite)item);
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
                this.view = new Composite(service.gEditArea(), this.entityList);
                this.service.addComponent(this.view);

                this.containerList.add(this.view);
                this.menubar.EnabledMethodUnGroupObj(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        this.menubar.setUnGroupObjListener(e -> {
            this.service.removeComponent(this.view);
            this.view = null;
        });
    }
}
