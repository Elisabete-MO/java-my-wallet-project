package edu.my.wallet.exceptions;

/**
 * This exception is thrown when the given music is not found.
 */
public class CurrencyNotFoundException extends RuntimeException {
  public CurrencyNotFoundException(String message) {
    super(message);
  }
}
