package cbse.labAssignment.virtualCoffeeShop.Products.Condiments;

import cbse.labAssignment.virtualCoffeeShop.Products.Beverage;
import cbse.labAssignment.virtualCoffeeShop.Products.BeverageCondiment;

public class Milk extends BeverageCondiment {
    Beverage beverage;
    private Double cost;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
        this.cost = 0.5;
    }

    @Override
    public String getDescription() {
        return  "Milk " + beverage.getDescription()  ;
    }

    @Override
    public Double getPrice() {
        return beverage.getPrice() + cost;
    }
}
