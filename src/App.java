import java.time.LocalDate;


import drinks.Beer;
import drinks.Juice;
import fryChicken.West2FriedChickenRestauran;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        West2FriedChickenRestauran restauran = new West2FriedChickenRestauran(114154);
        restauran.purchaesIn(LocalDate.now(), 
        new Juice("葡萄汁",15),
        new Juice("葡萄汁",15),
        new Juice("葡萄汁",15),
        new Juice("葡萄汁",15),
        
        new Beer("林哥哥口嚼酒",1.0,0.88f),
        new Beer("林哥哥口嚼酒",1.0,0.88f),
        new Beer("林哥哥口嚼酒",1.0,0.88f),
        new Beer("林哥哥口嚼酒",1.0,0.88f)
        );


        restauran.sendSetMeal(1);
        restauran.sendSetMeal(3);

        restauran.purchaesIn(LocalDate.now(), new Juice("葡汁",150000000));
    }
}
