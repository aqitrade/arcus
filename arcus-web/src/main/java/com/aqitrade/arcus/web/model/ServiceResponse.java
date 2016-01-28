package com.aqitrade.arcus.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Model to represent REST response from arcus.
 *
 * <p>
 * Every REST endpoint should return this model class from Controller methods so that arcus response
 * will be consistent
 * </p>
 *
 * @author pani
 *
 * @param <T>
 */
@JsonInclude(Include.NON_NULL)
public class ServiceResponse<T> {

  public enum Status {
    success, error
  }

  private Status status;
  private T data;
  private ErrorMessage error;

  public ServiceResponse() {
    this.status = Status.success;
  }

  public ServiceResponse(T data) {
    this.data = data;
    this.status = Status.success;
  }

  public ServiceResponse(ErrorMessage error) {
    this.error = error;
    this.status = Status.error;
  }

  /**
   * @return the status
   */
  public Status getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(Status status) {
    this.status = status;
  }

  /**
   * @return the data
   */
  public T getData() {
    return data;
  }

  /**
   * @param data the data to set
   */
  public void setData(T data) {
    this.data = data;
  }

  /**
   * @return the error
   */
  public ErrorMessage getError() {
    return error;
  }

  /**
   * @param error the error to set
   */
  public void setError(ErrorMessage error) {
    this.error = error;
  }

}
