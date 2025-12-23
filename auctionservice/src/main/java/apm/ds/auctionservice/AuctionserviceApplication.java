package apm.ds.auctionservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition (
        info = @Info(
                title = "Auction microservice REST API documentation",
                description = "documentation for the item microservice",
                version = "v1",
                contact = @Contact(
                        name = "Martin Grombanovski-222061/ Pavel Vasilevski-222070/ Angel Trajkov-222134",
                        email = "martingrombanovski@yahoo.com"
                )
        )
)
public class AuctionserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuctionserviceApplication.class, args);
    }

}
