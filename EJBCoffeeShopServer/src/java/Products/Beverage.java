package Products;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public abstract class Beverage implements Serializable {

    @Id
    private Long beverageId;

    protected String description;
    protected Double price;

    public String getDescription() {
        return description;
    }

    public abstract Double getPrice();

    public Long getId() {
        return beverageId;
    }

    public void setId(Long beverageId) {
        this.beverageId = beverageId;
    }
}
