import java.util.ArrayList;
import java.util.Iterator;

public class OrderedList {
    private ArrayList<Beverage> orderedBeverages;

    //add beverage into orderedBeverages List
    public void addBeverage(Beverage beverage){
        orderedBeverages.add(beverage);
    };

    //remove beverage from orderedBeverages List
    public void removeBeverage(Beverage beverage){
        orderedBeverages.remove(beverage);
    }

    //get orderedBeverages List
    public ArrayList<Beverage> getOrderedList(){
        return orderedBeverages;
    }

    //empty the orderedBeverages List
    public void empty(){
        orderedBeverages.clear();
    }

    //Sum up and return the price of beverages in the orderedBeverages List
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
