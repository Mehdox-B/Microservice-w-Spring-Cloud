package ma.mehdox.billing_service.Feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.mehdox.billing_service.dto.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name= "customer-service")
public interface CustomerRestClient {
    @GetMapping("/api/customers/{id}")
    @CircuitBreaker(name="customerServiceCB", fallbackMethod ="getDefaultCustomer")
    public Customer getCustomerById(@PathVariable Long id);

    @GetMapping("/api/customers")
    public PagedModel<Customer> getAllCustomers();


    default Customer getDefaultCustomer(Long id , Exception exception){
        return  Customer.builder()
                .name("Mehdox")
                .email("mehdox@gmail.com")
                .id(id)
                .build();
    }
}
