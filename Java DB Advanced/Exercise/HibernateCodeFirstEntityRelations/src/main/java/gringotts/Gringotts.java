package gringotts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Hristo Skipernov on 18/07/2017.
 */

@SpringBootApplication
public class Gringotts {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        SpringApplication.run(Gringotts.class, args);
    }
}