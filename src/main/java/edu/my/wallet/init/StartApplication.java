package edu.my.wallet.init;

import edu.my.wallet.models.UserRepository;
import edu.my.wallet.models.entities.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class that initializes the application with the admin and user users in
 * the database if they do not exist.
 */
@Component
public class StartApplication implements CommandLineRunner {
  @Autowired
  private UserRepository repository;

  @Transactional
  @Override
  public void run(String... args) throws Exception {
    Optional<User> adminUser = repository.findByUsername("admin");
    if (adminUser.isEmpty()) {
      User newAdminUser = new User();
      newAdminUser.setUsername("admin");
      newAdminUser.setEmail("admin@test.com");
      newAdminUser.setPassword("master123");
      // user.getRoles().add("MANAGERS");
      repository.save(newAdminUser);
    }
    Optional<User> user = repository.findByUsername("user");
    if (user.isEmpty()) {
      User newUser = new User();
      newUser.setUsername("user");
      newUser.setEmail("user@teste.com");
      newUser.setPassword("user123");
      // user.getRoles().add("USERS");
      repository.save(newUser);
    }
  }
}