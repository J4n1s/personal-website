package janis.website.backend.exception;

/**
 * NotFoundException is a custom unchecked exception that can be thrown
 * when a requested resource could not be found.
 */
public class NotFoundException extends RuntimeException {

  /**
   * Constructs a new NotFoundException with the specified detail message.
   *
   * @param message the detail message, which is saved for later retrieval by the getMessage()
   *                method.
   */
  public NotFoundException(String message) {
    super(message);
  }

  /**
   * Constructs a new NotFoundException with the specified detail message and cause.
   *
   * @param message the detail message, which is saved for later retrieval by the getMessage()
   *                method.
   * @param cause the cause, which is saved for later retrieval by the getCause() method.
   */
  public NotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructs a new NotFoundException with the specified cause.
   *
   * @param e the cause, which is saved for later retrieval by the getCause() method.
   */
  public NotFoundException(Exception e) {
    super(e);
  }
}
