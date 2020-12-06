package fryChicken;

import drinks.Drink;

public class SetMeal {
    private String name;
    private double prices;
    private String friedChikenName;
    private Drink drink;

    public SetMeal(String name, double prices, String friedChikenName, Drink drink) {
        this.name = name;
        this.prices = prices;
        this.friedChikenName = friedChikenName;
        this.drink = drink;
    }

    @Override
    public String toString() {
        return String.format("套餐名称：%s\n\t套餐炸鸡：%s\n\t套餐饮料：%s\n\t套餐价格：%4.2f", name,friedChikenName,drink.toString(),prices);
    }
    public double getPrices() {
        return prices;
    }
    public Drink getDrink() {
        return drink;
    }

    public String getName() {
        return name;
    }
}
