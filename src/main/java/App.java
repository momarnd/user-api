import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(value = "com.assignment.entities")
@EnableJpaRepositories
@EnableTransactionManagement
@ComponentScan(basePackages = "com.assignment")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}