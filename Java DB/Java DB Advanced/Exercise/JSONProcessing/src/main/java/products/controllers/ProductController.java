package products.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import products.dto.bindings.ProductImportDto;
import products.dto.views.ProductViewDto;
import products.serializers.JsonSerializer;
import products.services.ProductService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hristo Skipernov on 01/08/2017.
 */

@Controller
public class ProductController {
    private static final String PRODUCTS_JASON_INPUT_PATH = "/json/input/products.json";
    private static final String PRODUCTS_IN_RANGE_JASON_OUTPUT_PATH = "src/main/resources/json/output/productsInRange.json";
    private static final BigDecimal MIN_PRODUCT_PRICE = new BigDecimal(500);
    private static final BigDecimal MAX_PRODUCT_PRICE = new BigDecimal(1000);

    private final ProductService productService;
    private final JsonSerializer jsonSerializer;

    @Autowired
    public ProductController(ProductService productService, JsonSerializer jsonSerializer) {
        this.productService = productService;
        this.jsonSerializer = jsonSerializer;
    }

    public void importProducts() throws IOException, InstantiationException, IllegalAccessException {
        ProductImportDto[] productImportDtos = this.jsonSerializer.deserialize(ProductImportDto[].class, PRODUCTS_JASON_INPUT_PATH);
        this.productService.createMany(Arrays.asList(productImportDtos));
    }

    public void exportProductsInRange() throws InstantiationException, IllegalAccessException, IOException {
        List<ProductViewDto> productViewDtos = this.productService.getProductsInRange(MIN_PRODUCT_PRICE, MAX_PRODUCT_PRICE);
        this.jsonSerializer.serialize(productViewDtos, PRODUCTS_IN_RANGE_JASON_OUTPUT_PATH);
    }
}
