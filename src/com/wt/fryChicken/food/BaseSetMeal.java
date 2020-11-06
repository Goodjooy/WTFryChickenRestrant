package com.wt.fryChicken.food;

import com.wt.fryChicken.storehouse.raw.BaseRaw;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 套餐的抽象类
 */
public abstract class BaseSetMeal {
    protected String name;
    protected double prices;
    protected LinkedList<BaseRaw> contains;

    public BaseSetMeal(String name, double prices, BaseRaw... contains) {
        this.name = name;

        this.prices = prices;
        this.contains = new LinkedList<>();
        this.contains.addAll(Arrays.asList(contains));
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("套餐信息：\n" +
                "套餐名称：" + name + '\n' +
                "套餐价格" + prices + '\n' +
                "套餐内容：\n");

        for (BaseRaw baseRaw : contains) {
            info.append("\t").append(baseRaw.toString()).append('\t');
        }
        return info.toString();
    }
}
