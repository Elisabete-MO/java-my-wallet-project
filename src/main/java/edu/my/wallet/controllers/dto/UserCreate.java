package edu.my.wallet.controllers.dto;

import edu.my.wallet.models.entities.User;

/** User DTO.
 *
 * @param username name of the person
 * @param email email of the person
 * @param password password of the person
 * @param imageUrl image url of the person
 */
public record UserCreate(String username, String email, String password, String imageUrl) {

  /** Method to convert a user create to a user entity.
   *
   * @params username name of the person
   * @return a user entity
   */
  public User toUser() {
    return new User(username(), email(), password(), imageUrl());
  }

  /** Method to convert a user entity to a user with password.
   *
   * @param user user to be converted
   * @return a person with pssword
   */
  public static UserCreate fromUser(User user) {
    return new UserCreate(user.getUsername(), user.getEmail(), user.getPassword(),
        user.getImageUrl());
  }
}

