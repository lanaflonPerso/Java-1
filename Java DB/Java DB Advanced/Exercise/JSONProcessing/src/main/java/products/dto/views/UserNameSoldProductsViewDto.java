package products.dto.views;

import com.google.gson.annotations.Expose;

import java.util.Set;

/**
 * Created by Hristo Skipernov on 01/08/2017.
 */

public class UserNameSoldProductsViewDto {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private Set<ProductWithBuyerViewDto> soldProducts;

    public UserNameSoldProductsViewDto() {
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

    public Set<ProductWithBuyerViewDto> getSoldProducts() {
        return this.soldProducts;
    }

    public void setSoldProducts(Set<ProductWithBuyerViewDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
