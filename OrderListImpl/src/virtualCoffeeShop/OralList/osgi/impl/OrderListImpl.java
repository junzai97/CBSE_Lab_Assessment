package virtualCoffeeShop.OralList.osgi.impl;

import virtualCoffeeShop.OralList.osgi.ifce.IOrderList;
import virtualCoffeeShop.coffeeMaker.osgi.ifce.Beverage;
import java.util.ArrayList;
import java.util.Iterator;


public class OrderListImpl implements IOrderList{
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


    @Override
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
