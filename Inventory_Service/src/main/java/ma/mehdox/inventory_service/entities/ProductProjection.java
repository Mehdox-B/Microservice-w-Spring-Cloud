package ma.mehdox.inventory_service.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name ="all", types = Product.class)
public interface ProductProjection {
    String getName();
    double  getPrice();
    int getQuantity();

}
