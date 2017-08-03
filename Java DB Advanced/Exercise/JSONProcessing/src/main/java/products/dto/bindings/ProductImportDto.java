package products.dto.bindings;

import com.google.gson.annotations.Expose;
import products.dto.utilities.CategoryIdDto;
import products.dto.utilities.UserIdDto;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 01/08/2017.
 */

public class ProductImportDto {

    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    private UserIdDto buyer;

    private UserIdDto seller;

    private Set<CategoryIdDto> categories;

    public ProductImportDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public UserIdDto getBuyer() {
        return this.buyer;
    }

    public void setBuyer(UserIdDto buyer) {
        this.buyer = buyer;
    }

    public UserIdDto getSeller() {
        return this.seller;
    }

    public void setSeller(UserIdDto seller) {
        this.seller = seller;
    }

    public Set<CategoryIdDto> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<CategoryIdDto> categories) {
        this.categories = categories;
    }
}
