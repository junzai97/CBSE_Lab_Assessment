package cbse.labAssignment.virtualCoffeeShop.Products.Beverages;

import cbse.labAssignment.virtualCoffeeShop.Products.Beverage;

public class Espresso extends Beverage {

    public Espresso() {
        super.description = "Espresso";
        super.price = 7.00;
    }

    public Espresso(double price) {
        super.description = "Espresso";
        super.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
