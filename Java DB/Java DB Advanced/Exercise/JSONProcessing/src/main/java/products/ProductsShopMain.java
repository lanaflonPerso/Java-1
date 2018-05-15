package products;

import app.enums.StrategyType;
import app.utilities.Creator;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Hristo Skipernov on 01/08/2017.
 */

@SpringBootApplication
public class ProductsShopMain {
    public static void main(String[] args) {
        Creator.create(StrategyType.REPOSITORIES_AND_SERVICES, ProductsShopMain.class);
        SpringApplication app = new SpringApplication(ProductsShopMain.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
