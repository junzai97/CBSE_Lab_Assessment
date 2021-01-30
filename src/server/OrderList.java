package server;

import Products.Beverage;
import server.remote.OrderListRemote;

import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.Iterator;

@Stateful
public class OrderList implements OrderListRemote {
    private ArrayList<Beverage> orderedBeverages = new ArrayList<>();

    /**
     * @description add beverage into orderedBeverages List
     */
    public void addBeverage(Beverage beverage){
        orderedBeverages.add(beverage);
    };


    /**
     * @description remove beverage from orderedBeverages List
     */
    public void removeBeverage(Beverage beverage){
        orderedBeverages.remove(beverage);
    }


    /**
     * @description get orderedBeverages List
     */
    public ArrayList<Beverage> getOrderList(){
        return orderedBeverages;
    }


    /**
     * @description empty the orderedBeverages List
     */
    public void empty(){
        orderedBeverages.clear();
    }


    /**
     * @description Sum up and return the price of beverages in the orderedBeverages List
     */
    public double getPrice(){
        double totalPrice = 0.00D;
        Iterator beverageIterator = orderedBeverages.iterator();

        while(beverageIterator.hasNext()){
            Beverage beverage = (Beverage) beverageIterator.next();
            totalPrice += beverage.getPrice();
        }
        return totalPrice;
    }
}
