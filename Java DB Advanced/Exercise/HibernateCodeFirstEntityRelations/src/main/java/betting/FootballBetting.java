package betting;

import app.enums.StrategyType;
import app.utilities.Creator;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Hristo Skipernov on 18/07/2017.
 */

@SpringBootApplication
public class FootballBetting {
    public static void main(String[] args) {
        Creator.create(StrategyType.REPOSITORIES_AND_SERVICES, FootballBetting.class);
        SpringApplication app = new SpringApplication(FootballBetting.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}