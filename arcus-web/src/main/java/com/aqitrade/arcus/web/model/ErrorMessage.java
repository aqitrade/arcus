package com.aqitrade.arcus.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Model to represent error response.
 * 
 * @author pani
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(value = {"code", "message", "trace"})
public class ErrorMessage {
  private String errorCode;
  private String message;
  private String trace;

  public ErrorMessage(String errorCode, String message, String trace) {
    super();
    this.errorCode = errorCode;
    this.message = message;
    this.trace = trace;
  }

  public ErrorMessage(String errorCode, String message) {
    super();
    this.errorCode = errorCode;
    this.message = message;
  }

  /**
   * @return the errorCode
   */
  @JsonProperty("code")
  public String getErrorCode() {
    return errorCode;
  }

  /**
   * @param errorCode the errorCode to set
   */
  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * @return the trace
   */
  public String getTrace() {
    return trace;
  }

  /**
   * @param trace the trace to set
   */
  public void setTrace(String trace) {
    this.trace = trace;
  }
}
