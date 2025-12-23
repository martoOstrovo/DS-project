package apm.ds.userservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition (
        info = @Info(
                title = "User microservice REST API documentation",
                description = "documentation for the user microservice",
                version = "v1",
                contact = @Contact (
                        name = "Martin Grombanovski-222061/ Pavel Vasilevski-222070/ Angel Trajkov-222134",
                        email = "martingrombanovski@yahoo.com"
                )
        )
)
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

}
