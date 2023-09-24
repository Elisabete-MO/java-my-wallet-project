package edu.my.tunes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TunesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TunesApplication.class, args);
	}

}
