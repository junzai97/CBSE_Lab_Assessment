package cbse.labAssignment.virtualCoffeeShop;

import cbse.labAssignment.virtualCoffeeShop.Products.Beverage;
import cbse.labAssignment.virtualCoffeeShop.Products.Beverages.*;
import cbse.labAssignment.virtualCoffeeShop.Products.Condiments.*;

import java.util.ArrayList;
import java.util.Arrays;

public class CoffeeMakerImpl {
    public Beverage getBeverage(String beverageName) {
        if (beverageName.equals("Black Coffee")){
            return new BlackCoffee();
        }
        if (beverageName.equals("Espresso")){
            return new Espresso();
        }
        if (beverageName.equals("House Blend")){
            return new HouseBlend();
        }
        if (beverageName.equals("Black Decaf")){
            return new Decaf();
        }
        return null;
    }

    public Beverage addCondiment(String condimentName, Beverage beverage) {
        if (condimentName.equals("Milk")){
            return new Milk(beverage);
        }
        if (condimentName.equals("Whip")){
            return new Whip(beverage);
        }
        if (condimentName.equals("Soy")){
            return new Soy(beverage);
        }
        if (condimentName.equals("Mocha")){
            return new Mocha(beverage);
        }
        return beverage;
    }

    public ArrayList<Beverage> getAllAvailableBeverage() {
        return new ArrayList<>(Arrays.asList(
                new BlackCoffee(),
                new Espresso(),
                new HouseBlend(),
                new Decaf()
        ));
    }

    public ArrayList<Beverage> getAllAvailableCondiments() {
        return new ArrayList<>(Arrays.asList(
                new Milk(new NoBeverage()),
                new Whip(new NoBeverage()),
                new Soy(new NoBeverage()),
                new Mocha(new NoBeverage())
        ));
    }
}
