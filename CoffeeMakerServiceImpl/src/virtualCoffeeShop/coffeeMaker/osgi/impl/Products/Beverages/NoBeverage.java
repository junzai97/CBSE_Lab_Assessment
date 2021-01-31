package virtualCoffeeShop.coffeeMaker.osgi.impl.Products.Beverages;

import virtualCoffeeShop.coffeeMaker.osgi.ifce.Beverage;

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
