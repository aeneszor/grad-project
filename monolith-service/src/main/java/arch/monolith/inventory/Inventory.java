package arch.monolith.inventory;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="inventory")
public class Inventory extends PanacheEntity {

    public Long productId;
    public Long price;
    public Long numberOfProduct;

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", productId=" + productId +
                ", price=" + price +
                ", numberOfProduct=" + numberOfProduct +
                '}';
    }
}

