package server.remote;

import Products.Beverage;

import javax.ejb.Remote;

@Remote
public interface CoffeeMakerRemote {

    Beverage getBlackCoffee();

    Beverage getEspresso();

    Beverage getHouseBlend();

    Beverage getDecaf();

    Beverage addMilk(Beverage beverage);

    Beverage addWhip(Beverage beverage);

    Beverage addSoy(Beverage beverage);

    Beverage addMocha(Beverage beverage);
}
