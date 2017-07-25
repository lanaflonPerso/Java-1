package bank;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Hristo Skipernov on 18/07/2017.
 */

@SpringBootApplication
public class BankSystem {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BankSystem.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}