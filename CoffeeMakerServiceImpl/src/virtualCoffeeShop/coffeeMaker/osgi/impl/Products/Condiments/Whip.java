package virtualCoffeeShop.coffeeMaker.osgi.impl.Products.Condiments;

import virtualCoffeeShop.coffeeMaker.osgi.ifce.Beverage;
import virtualCoffeeShop.coffeeMaker.osgi.impl.Products.BeverageCondiment;

public class Whip extends BeverageCondiment {
    Beverage beverage;
    private Double cost;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
        this.cost = 0.8;
    }

    @Override
    public String getDescription() {
        return "Whip " + beverage.getDescription() ;
    }

    @Override
    public Double getPrice() {
        return beverage.getPrice() + cost;
    }
}
