package tn.ensi.ilsi.customermanagement_uservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class CustomermanagementUserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomermanagementUserviceApplication.class, args);
	}
}
