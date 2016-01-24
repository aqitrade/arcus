package com.aqitrade.arcus.core;

public enum ErrorCodes {

  // HTTP error codes
  INTERNAL_SERVER_HTTP_ERROR("500",
      "Unable to complete your request due to internal server error."), HTTP_OPERATION_NOT_SUPPORTED(
          "405", "Not Supported"), HTTP_NO_HANDLER_METHOD("404",
              "The requested resource not available"), MEDIA_TYPE_NOT_ACCEPTABLE_HTTP_ERROR("406",
                  "Media type not acceptable"), MEDIA_TYPE_NOT_SUPPORTED_HTTP_ERROR("415",
                      "Media type not supported"),

  // Arcus error codes
                      ENTITY_NOT_FOUND("001", "Entity not found"), DELETION_FAILED("002",
                          "Delete operation failed"), SAVE_FAILED("002",
                              "Save operation failed"), DB_OPERATION_FAILED("003",
                                  "DB operation failed");
  ;

  private final String errorCode;
  private final String errorMessage;

  ErrorCodes(String errorCode, String errorMessage) {
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }

  /**
   * @return the errorCode
   */
  public String code() {
    return errorCode;
  }

  /**
   * @return the errorMessage
   */
  public String message() {
    return errorMessage;
  }
}
