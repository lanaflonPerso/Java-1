package products.dto.views;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

/**
 * Created by Hristo Skipernov on 01/08/2017.
 */

public class ProductViewDto {

    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    @Expose
    private UserNameViewDto seller;

    public ProductViewDto() {
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

    public UserNameViewDto getSeller() {
        return this.seller;
    }

    public void setSeller(UserNameViewDto seller) {
        this.seller = seller;
    }
}
