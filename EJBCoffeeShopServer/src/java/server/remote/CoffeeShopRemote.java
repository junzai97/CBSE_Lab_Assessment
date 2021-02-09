package server.remote;

import Products.Beverage;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CoffeeShopRemote {

    List<Beverage> getCoffeeMenu();

    List<Beverage> getCondimentsMenu();

    List<Beverage> getOrderedBeverages();

    void addBeverageIntoOrderList(Beverage beverage);

    void removeBeverageFromOrderList(Beverage beverage);

    double getOrderedBeveragesTotalPrice();

    void checkOut();

    Beverage addCondiment(int condimentNumber, Beverage coffee);

}
