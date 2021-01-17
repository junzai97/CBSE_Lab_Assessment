package Products.Condiments;

import Products.Beverage;
import Products.BeverageCondiment;

public class Soy extends BeverageCondiment {

    Beverage beverage;
    private Double cost;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
        this.cost = 0.4;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public Double getPrice() {
        return beverage.getPrice() + cost;
    }
}
