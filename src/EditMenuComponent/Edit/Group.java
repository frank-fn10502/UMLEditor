package EditMenuComponent.Edit;

import java.util.List;

import EditAreaComponent.Composite;
import EditAreaComponent.UMLObject;
import EditMode.Select;

public class Group extends MenuItemEdit {

    private Select select;

    public Group(EditMode.Select select) {
        super("Group");
        this.select = select;
        this.setAction();
    }

    @Override
    public void selectChanged(List<UMLObject> umlObjs) {
        super.selectChanged(umlObjs);
        
        if (umlObjs.size() >= 2) {
            this.setEnabled(true);
        } else {
            this.setEnabled(false);
        }
    }

    void setAction() {
        this.addActionListener(x -> {
            Composite composite = new Composite(this.umlObjs);
            for (UMLObject umlObject : umlObjs) {
                this.editArea.removeUMLObject(umlObject);
            }

            this.editArea.addUMLObject(composite);
            this.select.clearAllSelectUMLObj();
        });
    }
}
