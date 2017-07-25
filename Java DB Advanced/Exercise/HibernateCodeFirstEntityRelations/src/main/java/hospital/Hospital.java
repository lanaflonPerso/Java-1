package hospital;

import app.enums.StrategyType;
import app.utilities.Creator;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Hristo Skipernov on 18/07/2017.
 */
@SpringBootApplication
public class Hospital {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Creator.create(StrategyType.REPOSITORIES_AND_SERVICES, Hospital.class);
        SpringApplication app = new SpringApplication(Hospital.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
