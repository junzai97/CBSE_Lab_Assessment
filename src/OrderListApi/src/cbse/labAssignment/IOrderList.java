package OrderListApi.src.cbse.labAssignment;

import Products.Beverage;

import java.util.ArrayList;

public interface IOrderList {
    double getPrice(ArrayList<Beverage> orderedBeverages);
}
