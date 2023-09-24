package edu.my.tunes.exceptions;

/**
 * This exception is thrown when the given music is not found.
 */
public class MusicNotFoundException extends RuntimeException {
  public MusicNotFoundException(String message) {
    super(message);
  }
}
