package products.dto.views;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

/**
 * Created by Hristo Skipernov on 02/08/2017.
 */
public class ProductNamePriceViewDto {

    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    public ProductNamePriceViewDto() {
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
}
