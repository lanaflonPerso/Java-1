package photographers;

import app.enums.StrategyType;
import app.utilities.Creator;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Hristo Skipernov on 30/07/2017.
 */

@SpringBootApplication
public class PhotographySystem {
    public static void main(String[] args) {
        Creator.create(StrategyType.REPOSITORIES_AND_SERVICES, PhotographySystem.class);
        SpringApplication app = new SpringApplication(PhotographySystem.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
