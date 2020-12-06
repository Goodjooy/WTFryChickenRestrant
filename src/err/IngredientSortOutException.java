package err;

import drinks.Drink;

public class IngredientSortOutException extends RuntimeException {

    private Drink drink;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public IngredientSortOutException (Drink drink){
        this.drink=drink;
    }
    @Override
    public String toString() {
        return String.format("饮料“%s”已经售罄!",drink.toString());
    }
    @Override
    public String getMessage() {
        return toString();
    }
    public Drink getDrink() {
        return drink;
    }
    
}
