package OrderListImpl.src.cbse.labAssignment;

import OrderListApi.src.cbse.labAssignment.IOrderList;
import Products.Beverage;
import java.util.ArrayList;
import java.util.Iterator;


public class OrderListImpl implements IOrderList{

    @Override
    public double getPrice(ArrayList<Beverage> orderedBeverages){
        double totalPrice = 0.00D;
        Iterator beverageIterator = orderedBeverages.iterator();

        while(beverageIterator.hasNext()){
            Beverage beverage = (Beverage) beverageIterator.next();
            totalPrice += beverage.getPrice();
        }
        return totalPrice;
    }
}
