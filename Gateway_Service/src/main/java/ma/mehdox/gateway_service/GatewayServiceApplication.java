package ma.mehdox.gateway_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.*;

@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
}
