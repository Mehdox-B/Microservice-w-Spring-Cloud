package ma.mehdox.customer_service;

import ma.mehdox.customer_service.entities.Customer;
import ma.mehdox.customer_service.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args ->{
			//------Save List of Customers--------//
			customerRepository.save(Customer.builder()
					.name("mehdox")
					.email("mehdiben@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("mehdox1")
					.email("mehdiben1@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("mehdox2")
					.email("mehdiben2@gmail.com")
					.build());
			customerRepository.save(Customer.builder()
					.name("mehdox3")
					.email("mehdiben3@gmail.com")
					.build());
			//-----------Find and Displays the list of all the customers------------//
			customerRepository.findAll().forEach(customer -> {
				System.out.println("=============================");
				System.out.println(customer.getId());
				System.out.println(customer.getName());
				System.out.println(customer.getEmail());
				System.out.println("=============================");
			});
		};
	}

}
