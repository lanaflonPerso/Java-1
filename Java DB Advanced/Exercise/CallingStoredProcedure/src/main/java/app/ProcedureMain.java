package app;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Hristo Skipernov on 20/07/2017.
 */
@SpringBootApplication
public class ProcedureMain {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ProcedureMain.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
