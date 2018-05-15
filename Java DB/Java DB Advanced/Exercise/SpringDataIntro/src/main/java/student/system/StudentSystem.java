package student.system;

import app.enums.StrategyType;
import app.utilities.Creator;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Hristo Skipernov on 22/07/2017.
 */

@SpringBootApplication
public class StudentSystem {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(StudentSystem.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}