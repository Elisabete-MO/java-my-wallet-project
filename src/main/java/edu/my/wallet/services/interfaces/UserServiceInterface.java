package edu.my.wallet.services.interfaces;

import edu.my.wallet.controllers.dto.UserDto;
import edu.my.wallet.models.entities.User;

import java.util.List;

/**
 * UserService interface for User entity operations that implements the CRUD
 * operations and the strategy pattern for the multiple implementations of the
 * same.
 */
public interface UserServiceInterface {
  List<UserDto> findAll();

  UserDto findByUsername(String username);

  void save(User user);

  void update(UserDto user);

  void delete(String username);
}
