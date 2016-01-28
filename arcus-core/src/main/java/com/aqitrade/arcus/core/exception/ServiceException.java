package com.aqitrade.arcus.core.exception;

import com.aqitrade.arcus.core.ErrorCodes;

/**
 * Arcus framework exception base class.
 * 
 * We recommend to use inner classes of {@link ServiceException} instead of creating Custom
 * exception.
 * 
 * @author pani
 *
 */
public abstract class ServiceException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  private String code;

  public ServiceException(String message) {
    super(message);
  }

  public ServiceException(String code, String message) {
    super(message);
    this.code = code;
  }

  public ServiceException(String code, String message, Throwable cause) {
    super(message, cause);
    this.code = code;
  }

  public ServiceException(ErrorCodes errorcode, Throwable cause) {
    super(errorcode.message(), cause);
    this.code = errorcode.code();
  }

  public ServiceException(ErrorCodes errorcode, String message, Throwable cause) {
    super(message, cause);
    this.code = errorcode.code();
  }

  public ServiceException(ErrorCodes errorcode) {
    super(errorcode.message());
    this.code = errorcode.code();
  }

  public ServiceException(ErrorCodes errorcode, String message) {
    super(message);
    this.code = errorcode.code();
  }


  /**
   * @return the code
   */
  public String getCode() {
    return code;
  }

  public static class EntityNotFoundException extends ServiceException {

    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(String message) {
      super(ErrorCodes.ENTITY_NOT_FOUND, message);
    }

    public EntityNotFoundException(ErrorCodes errorCode) {
      super(errorCode);
    }

  }

  public static class DataAccessException extends ServiceException {

    private static final long serialVersionUID = 1L;

    public DataAccessException(ErrorCodes errorCode, String message) {
      super(ErrorCodes.ENTITY_NOT_FOUND, message);
    }

    public DataAccessException(ErrorCodes errorCode, String message, Throwable cause) {
      super(ErrorCodes.ENTITY_NOT_FOUND, message, cause);
    }

    public DataAccessException(ErrorCodes errorCode, Throwable cause) {
      super(ErrorCodes.ENTITY_NOT_FOUND, cause);
    }
  }

  public static class NotificationException extends ServiceException {

    private static final long serialVersionUID = 1L;

    public NotificationException(String message) {
      super(ErrorCodes.NOTIFICATION_FAILED, message);
    }

    public NotificationException(String message, Throwable cause) {
      super(ErrorCodes.NOTIFICATION_FAILED, message, cause);
    }
  }

  public static class BadRequest extends ServiceException {

    private static final long serialVersionUID = 1L;

    public BadRequest(String message) {
      super(ErrorCodes.NOTIFICATION_FAILED, message);
    }

    public BadRequest(String message, Throwable cause) {
      super(ErrorCodes.NOTIFICATION_FAILED, message, cause);
    }

    public BadRequest(ErrorCodes errorCode) {
      super(errorCode);
    }
  }
}
