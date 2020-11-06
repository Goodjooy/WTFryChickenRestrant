package com.wt.fryChicken.storehouse.FryFood;

import com.wt.fryChicken.kitchen.cooker.Operate;
import com.wt.fryChicken.storehouse.raw.BaseRaw;

import java.time.LocalDate;

public class FryChicken extends FryFood {
    protected FryChicken(String name, int QGP, LocalDate productData, double prices) {
        super(name, QGP, productData, prices);
    }

    @Override
    public boolean isCanBeOperate(Operate operate) {
        return false;
    }

    @Override
    public BaseRaw setOperate(Operate operate) {
        return null;
    }
}
