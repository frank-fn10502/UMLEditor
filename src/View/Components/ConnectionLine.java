package View.Components;

import java.awt.Container;

import utils.Points;

public class ConnectionLine extends EditComponent{
    public ConnectionLine(Container c) {
        super(c);
    }
    protected Points start;
    protected Points end;

    //根據 start 和 end 來畫線
}
