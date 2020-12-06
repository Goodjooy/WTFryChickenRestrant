package fryChicken;

import drinks.Drink;
import err.IngredientSortOutException;
import err.OverdraftSortOutException;

public interface FriedChickenResturant {
    public boolean sendSetMeal(SetMeal meal)throws IngredientSortOutException;
    public boolean packageIn(Drink drink[])throws OverdraftSortOutException;
}
