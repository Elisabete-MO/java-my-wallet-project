package edu.my.wallet.exceptions;

/**
 * This exception is thrown when the given user is not found.
 */
public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String message) {
    super(message);
  }
}
