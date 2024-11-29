package ma.mehdox.billing_service.Feign;

import ma.mehdox.billing_service.dto.Customer;
import ma.mehdox.billing_service.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {
    @GetMapping("/products_api/api/{id}")
    public Product getProductById(@PathVariable String id);

    @GetMapping("/products_api/products")
    public PagedModel<Product> getAllProducts();
}
