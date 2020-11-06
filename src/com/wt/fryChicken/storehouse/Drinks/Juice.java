package com.wt.fryChicken.storehouse.Drinks;

import com.wt.fryChicken.kitchen.cooker.Operate;
import com.wt.fryChicken.storehouse.raw.BaseRaw;

import java.time.LocalDate;

public class Juice extends Drinks {
    Juice( LocalDate productData, double prices) {
        super("果汁", 2, productData, prices);
    }

    @Override
    public BaseRaw setOperate(Operate operate) {
        return null;
    }
}
