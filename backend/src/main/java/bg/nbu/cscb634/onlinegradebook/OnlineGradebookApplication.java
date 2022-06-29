package bg.nbu.cscb634.onlinegradebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EntityScan(basePackages = "com.example.onlinegradebook.model")
@EntityScan(basePackages = "com.example.onlinegradebook")
@EnableJpaRepositories(basePackages = "com.example.onlinegradebook")
@SpringBootApplication()
public class OnlineGradebookApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineGradebookApplication.class, args);
    }

}
