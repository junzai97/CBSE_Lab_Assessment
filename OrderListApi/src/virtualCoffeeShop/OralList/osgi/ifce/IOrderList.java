package virtualCoffeeShop.OralList.osgi.ifce;

import virtualCoffeeShop.coffeeMaker.osgi.ifce.Beverage;

import java.util.ArrayList;

public interface IOrderList {
    /**
     * @description add beverage into orderedBeverages List
     */
    public void addBeverage(Beverage beverage);


    /**
     * @description remove beverage from orderedBeverages List
     */
    public void removeBeverage(Beverage beverage);


    /**
     * @description get orderedBeverages List
     */
    public ArrayList<Beverage> getOrderList();


    /**
     * @description empty the orderedBeverages List
     */
    public void empty();



    double getPrice();
}
