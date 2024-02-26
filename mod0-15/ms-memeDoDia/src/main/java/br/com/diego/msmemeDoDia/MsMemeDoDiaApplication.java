package br.com.diego.msmemeDoDia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.diego.msmemeDoDia")
public class MsMemeDoDiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMemeDoDiaApplication.class, args);
	}

}
