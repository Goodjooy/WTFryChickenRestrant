package com.wt.fryChicken.kitchen;

import com.wt.fryChicken.kitchen.container.BaseContainer;
import com.wt.fryChicken.kitchen.cooker.BaseCooker;
import com.wt.fryChicken.storehouse.raw.BaseRaw;

import java.util.ArrayList;
import java.util.LinkedList;

//后厨管理
public class KitchenAdmin {
    private ArrayList<BaseCooker> cookers = new ArrayList<>();
    private ArrayList<BaseContainer> containers = new ArrayList<>();
    public KitchenAdmin(){

    }

    public void update() {
        for (BaseCooker cooker : cookers) {
            cooker.update();
        }
        for (BaseContainer container :
                containers) {
            container.containerStatusUpdate();
        }
    }

    public boolean cookRaw(LinkedList<BaseRaw> rawLinkedList, int cookerIndex) {
        if (rawLinkedList.size() == 0) return false;
        BaseCooker cooker = cookers.get(cookerIndex);
        return (cooker.SetRaw(rawLinkedList) != 0);
    }

}
