package arch.monolith.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="inventory")
public class Inventory extends PanacheEntity {

    public Long productID;
    public Long numberOfProduct;

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", productID=" + productID +
                ", numberOfProduct=" + numberOfProduct +
                '}';
    }
}

