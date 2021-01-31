package Products;

import javax.persistence.Entity;

@Entity
public abstract class Beverage {

    protected String description;
    protected Double price;

    public String getDescription() {
        return description;
    }

    public abstract Double getPrice();
}
