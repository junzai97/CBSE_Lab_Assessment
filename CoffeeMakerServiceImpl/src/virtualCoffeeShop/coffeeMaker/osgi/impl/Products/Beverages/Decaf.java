package virtualCoffeeShop.coffeeMaker.osgi.impl.Products.Beverages;

import virtualCoffeeShop.coffeeMaker.osgi.ifce.Beverage;

public class Decaf extends Beverage {
    public Decaf() {
        super.description = "Decaf Coffee";
        super.price = 5.50;
    }

    public Decaf(double price) {
        super.description = "Decaf Coffee";
        super.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
