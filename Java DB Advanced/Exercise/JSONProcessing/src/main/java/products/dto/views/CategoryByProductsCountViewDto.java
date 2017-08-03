package products.dto.views;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Hristo Skipernov on 01/08/2017.
 */

public class CategoryByProductsCountViewDto {

    @Expose
    private String category;

    @Expose
    private BigInteger count;

    @Expose
    private BigDecimal averagePrice;

    @Expose
    private BigDecimal totalRevenue;

    public CategoryByProductsCountViewDto() {
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigInteger getCount() {
        return this.count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }

    public BigDecimal getAveragePrice() {
        return this.averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return this.totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
