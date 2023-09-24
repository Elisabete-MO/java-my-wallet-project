package edu.my.tunes.controllers.dto;

import edu.my.tunes.models.entities.User;

/** User DTO.
 *
 * @param username name of the person
 * @param email email of the person
 * @param imageUrl image url of the person
 */
public record UserDto(String username, String email, String imageUrl) {

  /** Method to convert a user entity to a user dto.
   *
   * @param user user to be converted
   * @return a user dto
   */
  public static UserDto fromUser(User user) {
    return new UserDto(user.getUsername(), user.getEmail(),
        user.getImageUrl());
  }

  public User toUser() {
    return new User(username(), email(), imageUrl());
  }

  public String getUsername() {
    return this.username;
  }

  public String getEmail() {
    return this.email;
  }

  public String getImageUrl() {
    return this.imageUrl;
  }
}

