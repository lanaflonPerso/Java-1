package vehicles;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Hristo Skipernov on 23/07/2017.
 */

@SpringBootApplication
public class VehiclesSystem {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(VehiclesSystem.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
