package com.wt.fryChicken.storehouse.FryFood;

import com.wt.fryChicken.storehouse.raw.BaseRaw;

import java.time.LocalDate;

public abstract class FryFood extends BaseRaw {
    protected FryFood(String name, int QGP, LocalDate productData, double prices) {
        super(name, QGP, productData, prices);
    }
}
