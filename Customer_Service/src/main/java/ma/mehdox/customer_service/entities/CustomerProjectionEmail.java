package ma.mehdox.customer_service.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "email",types = Customer.class)
public interface CustomerProjectionEmail {
    String getEmail();
}
