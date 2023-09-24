package edu.my.tunes.exceptions;

/**
 * This exception is thrown when the given album is not found.
 */
public class AlbumNotFoundException extends RuntimeException {
  public AlbumNotFoundException(String message) {
    super(message);
  }
}
