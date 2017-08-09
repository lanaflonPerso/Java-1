package wedding;

import app.enums.StrategyType;
import app.utilities.Creator;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeddingSystem {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(WeddingSystem.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
