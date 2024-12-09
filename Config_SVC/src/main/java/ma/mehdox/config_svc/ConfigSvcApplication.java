package ma.mehdox.config_svc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
//This Annotation is for activating the Config Server the project
@EnableConfigServer
public class ConfigSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigSvcApplication.class, args);
	}

}
