package edu.my.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Principal class of the application that starts the Spring Boot application
 * and enables the Feign Client to make requests to the other microservices
 * of the system (wallet, user, and transaction).
 */
@EnableFeignClients
@SpringBootApplication
public class WalletApplication {
  public static void main(String[] args) {
    SpringApplication.run(WalletApplication.class, args);
  }
}
