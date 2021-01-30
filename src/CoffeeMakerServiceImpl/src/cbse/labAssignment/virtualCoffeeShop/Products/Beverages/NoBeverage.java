package cbse.labAssignment.virtualCoffeeShop.Products.Beverages;

import cbse.labAssignment.virtualCoffeeShop.Products.Beverage;

public class NoBeverage extends Beverage {

    public NoBeverage() {
        super.description = "";
        super.price = 0.00;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
