package com.wt.fryChicken.storehouse.Drinks;

import com.wt.fryChicken.kitchen.cooker.Operate;
import com.wt.fryChicken.storehouse.raw.BaseRaw;

import java.time.LocalDate;

public class Beer extends Drinks {
    float alcoholicLevel =40;

    Beer(LocalDate productData, double prices) {
        super("啤酒",30, productData, prices);
    }

    @Override
    public BaseRaw setOperate(Operate operate) {
        if(isCanBeOperate(operate))return this;
        switch (operate){
            case LOW_TEMPLATE -> {
                return new FrozenBeer(productData,prices);
            }

            default -> {
                return this;
            }
        }
    }
}
