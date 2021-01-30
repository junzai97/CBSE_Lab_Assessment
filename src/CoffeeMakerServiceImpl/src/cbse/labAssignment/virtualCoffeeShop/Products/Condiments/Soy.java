package cbse.labAssignment.virtualCoffeeShop.Products.Condiments;

import cbse.labAssignment.virtualCoffeeShop.Products.Beverage;
import cbse.labAssignment.virtualCoffeeShop.Products.BeverageCondiment;

public class Soy extends BeverageCondiment {

    Beverage beverage;
    private Double cost;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
        this.cost = 0.4;
    }

    @Override
    public String getDescription() {
        return "Soy " + beverage.getDescription() ;
    }

    @Override
    public Double getPrice() {
        return beverage.getPrice() + cost;
    }
}
