package ma.mehdox.inventory_service;

import ma.mehdox.inventory_service.entities.Product;
import ma.mehdox.inventory_service.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args ->{
			//-----------Save products to in memory database--------------//
			productRepository.save(Product.builder()
							.id(UUID.randomUUID().toString())
							.name("Lenovo E15 Gen 2")
							.price(10000.00)
							.quantity(21)
					.build());
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("Lenovo T14 S")
					.price(9000.00)
					.quantity(19)
					.build());
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("HP ELITEBOOK GEN 6")
					.price(12000.00)
					.quantity(9)
					.build());
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("Lenovo X1 Gen 9")
					.price(20000.00)
					.quantity(5)
					.build());
			//-----------------Load and Display Products to the console-----------//
			productRepository.findAll().forEach(product -> {
				System.out.println("======================================");
				System.out.println(product.getId());
				System.out.println(product.getName());
				System.out.println(product.getPrice()+" "+"DH");
				System.out.println(product.getQuantity());
				System.out.println("=====================================");
			});
		};
	}

}
