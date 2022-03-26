package View.Components.base;

import java.awt.*;

/**
 * UML 在邊及區域的圖像化
 */
public abstract class EditComponent {
    // sub class view 會據需求加入 swing component 當作 view 的一部分
    // 並將自己的 component 加入到 Container 中，也可以沒有 component
    protected Container container;

    public EditComponent(Container c) {
        this.container = c;
    }

    /**
     * main view 會傳入 g，EditComponent 實作畫圖
     * 
     * @param g //由 main view 傳入實體
     */
    public void draw(Graphics g) {
        System.out.println("no implement");
    }

    /**
     * 移除加入 container 的 component, 在銷毀這一 class 前需要先呼叫。
     */
    public void destoryEntity() {
        //System.out.println("remove swing component from Container");
    }
}
