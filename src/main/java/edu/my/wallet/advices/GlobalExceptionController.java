package edu.my.wallet.advices;

import edu.my.wallet.exceptions.CurrencyNotFoundException;
import edu.my.wallet.exceptions.UserNotFoundException;
import edu.my.wallet.exceptions.WrongArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler.
 */
@ControllerAdvice
public class GlobalExceptionController {

  private final Logger logger =
      LoggerFactory.getLogger(GlobalExceptionController.class);

  @ExceptionHandler({
      CurrencyNotFoundException.class,
      UserNotFoundException.class,
  })
  public ResponseEntity<String> handleNotFoundException(RuntimeException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
  }

  @ExceptionHandler(WrongArgumentException.class)
  public ResponseEntity<String> handleWrongArgumentException(RuntimeException e) {
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(Exception e) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(e.getMessage());
  }

  @ExceptionHandler(Throwable.class)
  public ResponseEntity<String> handleThrowable(Throwable e) {
    String message = "Unexpected error!";
    logger.error(message, e);
    return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(message);
  }
}
