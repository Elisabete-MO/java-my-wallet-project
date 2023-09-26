package edu.my.wallet.services;

import edu.my.wallet.controllers.dto.UserDto;
import edu.my.wallet.exceptions.UserNotFoundException;
import edu.my.wallet.models.UserRepository;
import edu.my.wallet.models.entities.User;
import edu.my.wallet.services.interfaces.UserServiceInterface;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the <b>Strategy</b> {@link UserServiceInterface}, which
 * can be injected by Spring (via {@link Autowired}). With this, as this class
 * is a {@link Service}, it will be treated as a <b>Singleton</b>.
 */
@Service
public class UserService implements UserServiceInterface {
  //Singleton: components injection with @Autowired
  @Autowired
  private UserRepository userRepository;

  //Strategy: Implement the methods defined in the interface.
  //Facade: Abstract integrations with subsystems, providing a simple interface.
  @Override
  public List<UserDto> findAll() {
    List<User> users = userRepository.findAll();
    return users.stream().map(e -> new UserDto(
      e.getUsername(),
      e.getEmail(),
      e.getImageUrl())).toList();
  }

  @Override
  public UserDto findByUsername(String username) {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UserNotFoundException(
            "Usuário não encontrado!"));

    return new UserDto(
        user.getUsername(),
        user.getEmail(),
        user.getImageUrl()
    );
  }

  @Override
  public void save(User user) {
    userRepository.save(user);
  }

  @Override
  public void update(UserDto user) {
    Optional<User> oldData =
        Optional.ofNullable(userRepository.findByUsername(user.getUsername())
            .orElseThrow(() -> new UserNotFoundException("Usuário não "
                + "encontrado!")));
    if (oldData.isPresent()) {
      User oldUser = oldData.get();
      oldUser.setEmail(user.getEmail());
      oldUser.setImageUrl(user.getImageUrl());
      oldUser.setPassword(oldData.get().getPassword());
      userRepository.save(oldUser);
    }
  }

  @Override
  public void delete(String username) {
    Optional<User> user =
        Optional.ofNullable(userRepository.findByUsername(username)
            .orElseThrow(NoSuchElementException::new));
    user.ifPresent(userRepository::delete);
  }
}