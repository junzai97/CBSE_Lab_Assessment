package cbse.labAssignment.virtualCoffeeShop;

import java.util.ArrayList;


public interface CoffeeMakerApi {
    public Beverage getBeverage(String beverageName);

    public Beverage addCondiment(String condimentName, Beverage beverage);

    public ArrayList<Beverage> getAllAvailableBeverage();

    public ArrayList<Beverage> getAllAvailableCondiments();
}
