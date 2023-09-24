package edu.my.tunes.services.interfaces;

import edu.my.tunes.controllers.dto.UserDto;
import edu.my.tunes.models.entities.User;

import java.util.List;
import java.util.Optional;

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
