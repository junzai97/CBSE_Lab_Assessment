package virtualCoffeeShop.coffeeMaker.osgi.impl;

import virtualCoffeeShop.coffeeMaker.osgi.ifce.CoffeeMakerApi;
import virtualCoffeeShop.coffeeMaker.osgi.ifce.Beverage;
import virtualCoffeeShop.coffeeMaker.osgi.impl.Products.Beverages.*;
import virtualCoffeeShop.coffeeMaker.osgi.impl.Products.Condiments.Milk;
import virtualCoffeeShop.coffeeMaker.osgi.impl.Products.Condiments.Mocha;
import virtualCoffeeShop.coffeeMaker.osgi.impl.Products.Condiments.Soy;
import virtualCoffeeShop.coffeeMaker.osgi.impl.Products.Condiments.Whip;


import java.util.ArrayList;
import java.util.Arrays;

public class CoffeeMakerImpl implements CoffeeMakerApi{

    @Override
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

    @Override
    public Beverage addCondiment(int condimentNumber, Beverage beverage) {
        if (condimentNumber == 1){
            return new Milk(beverage);
        }
        if (condimentNumber == 2){
            return new Whip(beverage);
        }
        if (condimentNumber == 3 ){
            return new Soy(beverage);
        }
        if (condimentNumber == 4){
            return new Mocha(beverage);
        }
        return beverage;
    }

    @Override
    public ArrayList<Beverage> getAllAvailableBeverage() {
        return new ArrayList<>(Arrays.asList(
                new BlackCoffee(),
                new Espresso(),
                new HouseBlend(),
                new Decaf()
        ));
    }

    @Override
    public ArrayList<Beverage> getAllAvailableCondiments() {
        return new ArrayList<>(Arrays.asList(
                new Milk(new NoBeverage()),
                new Whip(new NoBeverage()),
                new Soy(new NoBeverage()),
                new Mocha(new NoBeverage())
        ));
    }
}
