package Products.Beverages;

import Products.Beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        super.description = "House Blend";
        super.price = 6.50;
    }

    public HouseBlend(double price) {
        super.description = "House Blend";
        super.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
