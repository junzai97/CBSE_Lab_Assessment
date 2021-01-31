package virtualCoffeeShop.coffeeMaker.osgi.ifce;

import java.util.ArrayList;


public interface CoffeeMakerApi {
    Beverage getBeverage(String beverageName);

    Beverage addCondiment(int  condimentNumber, Beverage beverage);

    ArrayList<Beverage> getAllAvailableBeverage();

    ArrayList<Beverage> getAllAvailableCondiments();
}
