package EditMenuComponent.Edit;

import java.util.List;

import EditAreaComponent.Composite;
import EditAreaComponent.UMLObject;
import EditMode.Select;

public class UnGroup extends MenuItemEdit {

    private Select select;

    public UnGroup(EditMode.Select select) {
        super("UnGroup");
        this.select = select;
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
            this.setEnabled(true);
            return;
        }

        this.setEnabled(false);
    }

    void setAction() {
        this.addActionListener(x -> {
            for (UMLObject umlObject : umlObjs) {
                Composite composite = (Composite)umlObject;

                this.editArea.removeUMLObject(composite);
                for (UMLObject child : composite.getAllChilds()) {
                    this.editArea.addUMLObject(child);
                }
            }

            this.select.clearAllSelectUMLObj();
        });
    }

    private boolean containComposite(List<UMLObject> umlObjs) {
        for (UMLObject umlObject : umlObjs) {
            if (umlObject instanceof Composite)
                return true;
        }
        return false;
    }
}
