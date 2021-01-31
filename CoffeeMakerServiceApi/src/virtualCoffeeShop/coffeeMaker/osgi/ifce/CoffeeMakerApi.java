package virtualCoffeeShop.coffeeMaker.osgi.ifce;

import java.util.ArrayList;


public interface CoffeeMakerApi {
    Beverage getBeverage(String beverageName);

    Beverage addCondiment(String condimentName, Beverage beverage);

    ArrayList<Beverage> getAllAvailableBeverage();

    ArrayList<Beverage> getAllAvailableCondiments();

    Beverage addSoy(Beverage coffee);

    Beverage addMocha(Beverage coffee);

    Beverage addMilk(Beverage coffee);

    Beverage addWhip(Beverage coffee);
}
