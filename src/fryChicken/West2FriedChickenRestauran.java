package fryChicken;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

import drinks.Beer;
import drinks.Drink;
import drinks.Juice;
import drinks.Drink.statuses;
import err.IngredientSortOutException;
import err.OverdraftSortOutException;

public class West2FriedChickenRestauran implements FriedChickenResturant {
    private double remainMoney;

    private LinkedList<Beer> beers = new LinkedList<>();
    private LinkedList<Juice> juices = new LinkedList<>();
    private final static ArrayList<SetMeal> setMeals = new ArrayList<>(5);

    static {
        setMeals.add(new SetMeal("套餐1", 1222, "林哥哥杂交炸鸡", new Juice("葡萄汁")));
        setMeals.add(new SetMeal("套餐2", 767, "林哥哥杂交炸鸡", new Juice("葡汁")));
        setMeals.add(new SetMeal("套餐3", 769, "林哥哥杂交炸鸡", new Juice("萄汁")));
        setMeals.add(new SetMeal("套餐4", 909878, "林哥哥杂交炸鸡", new Beer("林哥哥口嚼酒")));
        setMeals.add(new SetMeal("套餐5", 546, "林哥哥杂交炸鸡", new Beer("林哥哥的麦汁啤酒")));
    }

    public void sendSetMeal(int mealid) {
        SetMeal meal = setMeals.get(mealid);
        try {
            sendSetMeal(meal);
            System.out.println(meal.toString());
        } catch (IngredientSortOutException e) {
            System.out.printf("非常抱歉，您选购的套餐< %s >由于< %s >，现已经售罄\n", meal.getName(), e.toString());
        }
    }

    public void purchaesInGroup(LocalDate date, Map<Drink, Integer> inInfoMap) {
        LinkedList<Drink> rDrinks = new LinkedList<>();
        for (Drink drink : inInfoMap.keySet()) {
            Integer size = inInfoMap.get(drink);
            for (int i = 0; i < size; i++) {
                rDrinks.add(drink);
            }
        }
        purchaesInBase(date, (Drink[]) rDrinks.toArray());
    }

    public void purchaesIn(LocalDate date, Drink... drinks) {
        purchaesInBase(date, drinks);
    }

    private void purchaesInBase(LocalDate date, Drink[] drinks) {
        Drink[] realDrink = new Drink[drinks.length];
        for (int i = 0; i < drinks.length; i++) {
            Drink t = drinks[i];
            if (t.getStatus() == statuses.NAME_AND_PICES) {
                if (t instanceof Juice) {
                    realDrink[i] = new Juice(t.getName(), t.getRawPices(), date);
                } else {
                    realDrink[i] = new Beer(t.getName(), t.getRawPices(), date, ((Beer) t).getAcholicLevel());
                }
            }
        }
        try {
            packageIn(realDrink);
        } catch (OverdraftSortOutException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public boolean sendSetMeal(SetMeal meal) throws IngredientSortOutException {
        LocalDate now = LocalDate.now();
        if (meal.getDrink() instanceof Beer) {
            use((Beer) meal.getDrink(), now);
        } else {
            use((Juice) meal.getDrink(), now);
        }
        remainMoney += meal.getPrices();
        return true;
    }

    @Override
    public boolean packageIn(Drink[] drink) throws OverdraftSortOutException {
        for (Drink drink2 : drink) {
            if (remainMoney - drink2.getRawPices() < 0) {
                throw new OverdraftSortOutException("购买<" + drink2.getName() + ">(" + drink2.getRawPices()
                        + ")超出余额！！！，超出" + -(remainMoney - drink2.getRawPices()) + "元");
            } else {
                remainMoney -= drink2.getRawPices();
                if (drink2 instanceof Beer) {
                    beers.addLast((Beer) drink2);

                } else {
                    juices.add((Juice) drink2);
                }
                System.out.printf("购入 %s \n,花费 %f \n", drink2.getName(), drink2.getRawPices());
                // return true;
            }
        }
        return true;
    }

    public West2FriedChickenRestauran(double remainMoney) {
        this.remainMoney = remainMoney;

    }

    private void use(Juice juice, LocalDate now) throws IngredientSortOutException {
        if (juices.size() == 0) {
            throw new IngredientSortOutException(juice);
        } else {
            for (Juice juice2 : juices) {
                if (juice2.equals(juice) && !juice2.isOverQPD(now)) {
                    juices.remove(juice2);
                    return;
                }
            }
            throw new IngredientSortOutException(juice);
        }
    }

    private void use(Beer beer, LocalDate now) throws IngredientSortOutException {
        for (Beer beer2 : beers) {
            if (beer2.equals(beer) && !beer2.isOverQPD(now)) {
                beers.remove(beer2);
                return;
            }
        }
        throw new IngredientSortOutException(beer);
    }
}
