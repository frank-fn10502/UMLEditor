package Services;

import java.util.*;

import View.EditArea;
import View.Components.*;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * 操作 EditArea 的 EditComponent
 */
public class EditComponentsService {

    public enum StatusSelect {
        IS_SELECTED,
        NONE,
        NEW_ONE
    }

    EditArea editArea;

    List<BaseObj> baseObjList;
    List<BaseObj> selectList;

    public EditComponentsService(EditArea editArea) {
        this.editArea = editArea;
        this.baseObjList = new ArrayList<BaseObj>();
        this.selectList = new ArrayList<BaseObj>();
    }

    public EditArea gEditArea() {
        return this.editArea;
    }

    public List<BaseObj> getSelectList() {
        return this.selectList;
    }

    public void clearSelectList() {
        for (BaseObj item : selectList) {
            item.showAnchorPoints(false);
        }
        this.selectList.clear();
    }

    public BaseObj getIntraComponent(Point p){
        for (BaseObj item : baseObjList) {
            if(item.isInteract(p)){
                return item;
            }
        }
        return null;
    }

    public StatusSelect select(Point p) {
        if (selectList.size() > 0) {
            if (this.isSelected(p))
                return StatusSelect.IS_SELECTED;

            this.clearSelectList();
        }
        if (trySelect(p))
            return StatusSelect.NEW_ONE;

        return StatusSelect.NONE;
    }

    public StatusSelect select(Rectangle rect) {
        if (this.trySelect(rect))
            return StatusSelect.NEW_ONE;

        return StatusSelect.NONE;
    }

    public void addComponent(EditComponent ec) {
        editArea.addEditComponent(ec);
        if (ec instanceof BaseObj) {
            baseObjList.add((BaseObj) ec);
        }
    }

    public void removeComponent(EditComponent ec) {
        editArea.removeEditComponent(ec);
        ec.destoryEntity();
    }

    boolean isSelected(Point p) {
        for (BaseObj s : selectList) {
            if (s.isInteract(p))
                return true;
        }
        return false;
    }

    boolean trySelect(Point p) {
        for (BaseObj item : baseObjList) {
            if (item.isInteract(p)) {
                this.addToSelectList(item);
                return true;
            }
        }
        return false;
    }

    boolean trySelect(Rectangle rect) {
        boolean result = false;
        for (BaseObj item : baseObjList) {
            if (item.isInteract(rect)) {
                this.addToSelectList(item);
                result = true;
            }
        }
        return result;
    }

    void addToSelectList(BaseObj item) {
        if(!this.selectList.contains(item))
        {
            this.selectList.add(item);
            item.showAnchorPoints(true);
        }
    }
}