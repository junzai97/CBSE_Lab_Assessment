package server.remote;

import Products.Beverage;

import javax.ejb.Remote;
import java.util.ArrayList;

@Remote
public interface MenuRemote {

    void addCoffee(Beverage coffee);

    ArrayList<Beverage> getCoffeeMenu();

    void addCondiments(Beverage condiment);

    ArrayList<Beverage> getCondimentsMenu();
}
