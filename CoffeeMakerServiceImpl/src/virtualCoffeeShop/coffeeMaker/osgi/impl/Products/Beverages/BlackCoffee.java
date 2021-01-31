package virtualCoffeeShop.coffeeMaker.osgi.impl.Products.Beverages;

import virtualCoffeeShop.coffeeMaker.osgi.ifce.Beverage;

public class BlackCoffee extends Beverage {

    public BlackCoffee() {
        super.description = "Black Coffee";
        super.price = 5.00;
    }

    public BlackCoffee(double price) {
        super.description = "Black Coffee";
        super.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
