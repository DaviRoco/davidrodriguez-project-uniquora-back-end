package davidrodriguez.com.uniquora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "davidrodriguez.com.uniquora")
public class UniquoraApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniquoraApplication.class, args);
    }

}
