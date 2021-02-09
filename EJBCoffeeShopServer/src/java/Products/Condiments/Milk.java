package Products.Condiments;

import Products.Beverage;
import Products.BeverageCondiment;

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
