package sales.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 18/07/2017.
 */

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    @Column(name = "product_name", length = 50)
    private String name;

    @Basic
    private double quantity;

    @Basic
    private double price;

    @OneToMany(mappedBy = "product")
    private Set<Sale> sales;

    public Product() {
    }

    public Product(String name, double quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Sale> getSales() {
        return this.sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
