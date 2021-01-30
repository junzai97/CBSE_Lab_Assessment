package server.remote;

import Products.Beverage;

import javax.ejb.Remote;
import java.util.ArrayList;
import java.util.Iterator;

@Remote
public interface OrderListRemote {

    void addBeverage(Beverage beverage);


    void removeBeverage(Beverage beverage);


    ArrayList<Beverage> getOrderList();


    void empty();


    double getPrice();
}
