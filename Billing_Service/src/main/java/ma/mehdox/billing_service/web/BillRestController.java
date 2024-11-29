package ma.mehdox.billing_service.web;

import ma.mehdox.billing_service.Feign.CustomerRestClient;
import ma.mehdox.billing_service.Feign.ProductRestClient;
import ma.mehdox.billing_service.entities.Bill;
import ma.mehdox.billing_service.repository.BillRepository;
import ma.mehdox.billing_service.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductRestClient productRestClient;
    @Autowired
    private ProductItemRepository productItemRepository;
    @GetMapping(path = "/bills/{id}")
    public Bill getBill(@PathVariable Long id){
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerID()));
       bill.getProductItems().forEach(productItem -> {
           productItem.setProduct(productRestClient.getProductById(productItem.getProductId()));
       });
        return bill;
    }
}
