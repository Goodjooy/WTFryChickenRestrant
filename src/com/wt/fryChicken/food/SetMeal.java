package com.wt.fryChicken.food;

import com.wt.fryChicken.storehouse.Drinks.Drinks;
import com.wt.fryChicken.storehouse.FryFood.FryChicken;
import com.wt.fryChicken.storehouse.raw.BaseRaw;

public class SetMeal extends BaseSetMeal {
    public SetMeal(String name , double prices, FryChicken fryChicken, Drinks drinks) {
        super(name,prices,fryChicken,drinks);
    }
}
