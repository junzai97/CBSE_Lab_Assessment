package Products.Beverages;

import Products.Beverage;

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
