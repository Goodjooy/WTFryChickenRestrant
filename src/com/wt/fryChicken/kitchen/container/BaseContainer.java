package com.wt.fryChicken.kitchen.container;

import com.wt.fryChicken.storehouse.raw.BaseRaw;

import java.util.LinkedList;

//容器抽象类
public abstract class BaseContainer {
    //容器容积
    int volume;
    //容器内容物
    LinkedList<BaseRaw>baseRawLinkedList;

    /**
     * 更新容器状态，修改内容物状态
     */
    public abstract void containerStatusUpdate();

}
