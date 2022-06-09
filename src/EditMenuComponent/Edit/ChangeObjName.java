package EditMenuComponent.Edit;

import java.util.List;

import javax.swing.JOptionPane;

import EditAreaComponent.BaseObj;
import EditAreaComponent.Composite;
import EditAreaComponent.UMLObject;

public class ChangeObjName extends MenuItemEdit {
    public ChangeObjName() {
        super("change object name");
        this.setAction();
    }

    @Override
    public void selectChanged(List<UMLObject> umlObjs) {
        super.selectChanged(umlObjs);
        if (umlObjs.size() == 0 || umlObjs.size() >= 2) {
            this.setEnabled(false);
            return;
        }

        if (this.containComposite(umlObjs)) {
            this.setEnabled(false);
            return;
        }

        this.setEnabled(true);
    }

    private boolean containComposite(List<UMLObject> umlObjs) {
        for (UMLObject umlObject : umlObjs) {
            if (umlObject instanceof Composite)
                return true;
        }
        return false;
    }

    void setAction() {
        this.addActionListener(x -> {
            for (UMLObject umlObject : umlObjs) {
                BaseObj baseObj = (BaseObj) umlObject;

                String name = JOptionPane.showInputDialog("enter the name: ");
                if (name != null && !name.isEmpty()) {
                    baseObj.changeName(name);
                }
            }
        });
    }
}
