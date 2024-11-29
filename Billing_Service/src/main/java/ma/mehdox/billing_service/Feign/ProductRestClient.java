package ma.mehdox.billing_service.Feign;

import ma.mehdox.billing_service.dto.Customer;
import ma.mehdox.billing_service.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {
    @GetMapping("/api/products/{id}")
    public Product getProductById(@PathVariable Long id);

    @GetMapping("/api/products{id}")
    public PagedModel<Product> getAllProducts();
}
