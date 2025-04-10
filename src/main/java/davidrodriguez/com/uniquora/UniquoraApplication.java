package davidrodriguez.com.uniquora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "davidrodriguez.com.uniquora")
@EnableJpaRepositories(basePackages = "davidrodriguez.com.uniquora")
@EntityScan(basePackages = "davidrodriguez.com.uniquora")
public class UniquoraApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniquoraApplication.class, args);
    }

}
