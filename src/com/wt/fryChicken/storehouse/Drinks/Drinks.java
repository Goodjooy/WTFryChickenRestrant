package com.wt.fryChicken.storehouse.Drinks;

import com.wt.fryChicken.kitchen.cooker.BaseCooker;
import com.wt.fryChicken.kitchen.cooker.Operate;
import com.wt.fryChicken.storehouse.raw.BaseRaw;

import java.time.LocalDate;

public abstract class Drinks extends BaseRaw {
    Drinks(String name, int QGP, LocalDate productData, double prices) {
        super(name, QGP, productData, prices);
    }

    /**
     * 饮料不应该能进行除了加热，保温，加冰外的任何操作
     *
     * @param operate 操作
     * @return 是否能进行该操作
     */
    @Override
    public boolean isCanBeOperate(Operate operate) {
        return operate.isTemplateOnly(operate);
    }
}
