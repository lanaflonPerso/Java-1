package products.dto.views;

import com.google.gson.annotations.Expose;

import java.util.Set;

/**
 * Created by Hristo Skipernov on 02/08/2017.
 */

public class ProductsNamePriceViewDto {

    @Expose
    private int count;

    @Expose
    private Set<ProductNamePriceViewDto> products;

    public ProductsNamePriceViewDto() {
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Set<ProductNamePriceViewDto> getProducts() {
        return this.products;
    }

    public void setProducts(Set<ProductNamePriceViewDto> products) {
        this.products = products;
        this.setCount(products.size());
    }
}
