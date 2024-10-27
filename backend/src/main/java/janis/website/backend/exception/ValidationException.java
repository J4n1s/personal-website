package janis.website.backend.exception;


/**
 * Exception thrown when validation of a resource fails.
 *
 * <p>This exception is used in the validation process to indicate
 * that the provided a provided resource does not meet the required
 * constraints or has invalid format.
 */
public class ValidationException extends RuntimeException {

  /**
   * Constructs a new ValidationException with the specified detail message.
   *
   * @param message the detail message indicating the reason for the exception
   */
  public ValidationException(String message) {
    super(message);
  }
}
