package sales.entities;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Hristo Skipernov on 18/07/2017.
 */

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private long id;

    @Column(name = "customer_name", length = 50)
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_sales_products"))
    private Product product;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "fk_sales_customers"))
    private Customer customer;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "store_location_id", foreignKey = @ForeignKey(name = "fk_sales_store_locations"))
    private StoreLocation storeLocation;

    @Basic
    private LocalDate date;

    public Sale() {
    }

    public Sale(String name, Product product, Customer customer, StoreLocation storeLocation, LocalDate date) {
        this.name = name;
        this.product = product;
        this.customer = customer;
        this.storeLocation = storeLocation;
        this.date = date;
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

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public StoreLocation getStoreLocation() {
        return this.storeLocation;
    }

    public void setStoreLocation(StoreLocation storeLocation) {
        this.storeLocation = storeLocation;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}