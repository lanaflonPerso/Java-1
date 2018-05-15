package products.dto.views;

import com.google.gson.annotations.Expose;

/**
 * Created by Hristo Skipernov on 01/08/2017.
 */

public class UserSoldProductsViewDto {

    private long id;

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private int age;

    @Expose
    private ProductsNamePriceViewDto soldProducts;

    public UserSoldProductsViewDto() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ProductsNamePriceViewDto getSoldProducts() {
        return this.soldProducts;
    }

    public void setSoldProducts(ProductsNamePriceViewDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
