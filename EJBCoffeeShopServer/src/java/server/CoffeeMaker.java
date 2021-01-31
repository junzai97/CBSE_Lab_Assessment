package server;

import Products.Beverage;
import Products.Beverages.BlackCoffee;
import Products.Beverages.Decaf;
import Products.Beverages.Espresso;
import Products.Beverages.HouseBlend;
import Products.Condiments.Milk;
import Products.Condiments.Mocha;
import Products.Condiments.Soy;
import Products.Condiments.Whip;
import server.remote.CoffeeMakerRemote;

public class CoffeeMaker implements CoffeeMakerRemote {

    public Beverage getBlackCoffee() {
        return new BlackCoffee();
    }

    public Beverage getEspresso() {
        return new Espresso();
    }

    public Beverage getHouseBlend() {
        return new HouseBlend();
    }

    public Beverage getDecaf() {
        return new Decaf();
    }

    public Beverage addMilk(Beverage beverage) {
        return new Milk(beverage);
    }

    public Beverage addWhip(Beverage beverage) {
        return new Whip(beverage);
    }

    public Beverage addSoy(Beverage beverage) {
        return new Soy(beverage);
    }

    public Beverage addMocha(Beverage beverage) {
        return new Mocha(beverage);
    }
}