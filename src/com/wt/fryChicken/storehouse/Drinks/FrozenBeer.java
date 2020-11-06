package com.wt.fryChicken.storehouse.Drinks;

import java.time.LocalDate;
//冰啤酒，更贵
public class FrozenBeer extends Beer {
    FrozenBeer(LocalDate productData, double rawPrices) {
        super(productData, rawPrices*50);
        this.name="冰啤酒";
    }
}
