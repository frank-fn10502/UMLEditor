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
        this.selectList.clear();
    }

    public StatusSelect select(Point point) {
        if (selectList.size() > 0) {
            // if 從 selectList 找到一個符合的
            // return SELECTED
            //  else
            // clear selectList
        }
        // if 從 baseObjList 找到一個符合的
        // 加到 select list
        // return NEWONE

        return StatusSelect.NONE;
    }

    public StatusSelect select(Rectangle rect) {
        // 套用 IOU 算法 找出所有相交的 baseObj
        // if 從 baseObjList 找到一個符合的
        // return NEWONE
        return StatusSelect.NONE;
    }

    public void addComponent(EditComponent ec) {
        editArea.addEditComponent(ec);
        // 這邊要判斷是否是 basicObj ? 用 isInstance
    }

    public void removeComponent(EditComponent ec) {
        editArea.removeEditComponent(ec);
        ec.destoryEntity();
    }
}
