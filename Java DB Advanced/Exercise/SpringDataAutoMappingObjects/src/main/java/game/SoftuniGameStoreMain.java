package game;

import app.enums.StrategyType;
import app.utilities.Creator;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Hristo Skipernov on 28/07/2017.
 */

@SpringBootApplication
public class SoftuniGameStoreMain {
    public static void main(String[] args) {
        Creator.create(StrategyType.REPOSITORIES_AND_SERVICES, SoftuniGameStoreMain.class);
        SpringApplication app = new SpringApplication(SoftuniGameStoreMain.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
