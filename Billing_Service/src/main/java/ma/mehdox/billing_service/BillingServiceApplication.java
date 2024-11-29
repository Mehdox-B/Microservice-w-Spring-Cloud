package ma.mehdox.billing_service;

import ma.mehdox.billing_service.Feign.CustomerRestClient;
import ma.mehdox.billing_service.Feign.ProductRestClient;
import ma.mehdox.billing_service.dto.Customer;
import ma.mehdox.billing_service.dto.Product;
import ma.mehdox.billing_service.entities.Bill;
import ma.mehdox.billing_service.entities.ProductItem;
import ma.mehdox.billing_service.repository.BillRepository;
import ma.mehdox.billing_service.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BillRepository billRepository,
										ProductItemRepository productItemRepository , CustomerRestClient customerRestClient ,
										ProductRestClient productRestClient){
		return args -> {
			//--------Fetch All Customers & Products  from The Remote Customers DataBase------//
			Collection<Customer> customers = customerRestClient.getAllCustomers().getContent();
			Collection<Product> products   = productRestClient.getAllProducts().getContent();

			//--------Create One Bill for Each Customer------ ------//
			customers.forEach(customer -> {
			  	Bill bill = Bill.builder()
						.customerID(customer.getId())
						.billingdate(new Date())
						.build();
				billRepository.save(bill);
				//-------------------------//
				products.forEach(product -> {
					ProductItem productItem = ProductItem.
							builder()
							.bill(bill)
							.productId(product.getId())
							.quantity(new Random().nextInt(10))
							.unitPrice(product.getPrice())
							.build();
					productItemRepository.save(productItem);
				});

			});
 		};
	}
}
