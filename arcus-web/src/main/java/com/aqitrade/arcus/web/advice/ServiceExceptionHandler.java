package com.aqitrade.arcus.web.advice;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.aqitrade.arcus.core.ErrorCodes;
import com.aqitrade.arcus.core.exception.ServiceException;
import com.aqitrade.arcus.web.model.ErrorMessage;
import com.aqitrade.arcus.web.model.ServiceResponse;

@ControllerAdvice
@Component
@EnableWebMvc
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {

  private final static Logger LOG = LoggerFactory.getLogger(ServiceExceptionHandler.class);

  @ExceptionHandler({ServiceException.class})
  protected ResponseEntity<Object> handleServiceException(ServiceException ex, WebRequest request) {
    LOG.error(ex.getMessage(), ex);
    ErrorMessage error =
        new ErrorMessage(ex.getCode(), ex.getMessage(), ExceptionUtils.getStackTrace(ex));
    ServiceResponse<Void> body = new ServiceResponse<Void>(error);
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    return super.handleExceptionInternal(ex, body, headers, HttpStatus.INTERNAL_SERVER_ERROR,
        request);
  }

  @ExceptionHandler({Exception.class})
  @Override
  protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    LOG.error(ex.getMessage(), ex);
    if (body == null || !body.getClass().isAssignableFrom(ServiceResponse.class)) {
      ErrorMessage error = new ErrorMessage(ErrorCodes.INTERNAL_SERVER_HTTP_ERROR.code(),
          ErrorCodes.INTERNAL_SERVER_HTTP_ERROR.message(), ExceptionUtils.getStackTrace(ex));
      body = new ServiceResponse<Void>(error);
    }
    return super.handleExceptionInternal(ex, body, headers, status, request);
  }

  @Override
  protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    return handlerExceptionInternal(ErrorCodes.HTTP_NO_HANDLER_METHOD, ex, headers, status,
        request);
  }

  @Override
  protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
      HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status,
      WebRequest request) {
    return handlerExceptionInternal(ErrorCodes.HTTP_OPERATION_NOT_SUPPORTED, ex, headers, status,
        request);
  }

  @Override
  protected ResponseEntity<Object> handleNoSuchRequestHandlingMethod(
      NoSuchRequestHandlingMethodException ex, HttpHeaders headers, HttpStatus status,
      WebRequest request) {
    return handlerExceptionInternal(ErrorCodes.HTTP_NO_HANDLER_METHOD, ex, headers, status,
        request);
  }

  @Override
  protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    return handlerExceptionInternal(ErrorCodes.INTERNAL_SERVER_HTTP_ERROR, ex, headers, status,
        request);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(
      HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatus status,
      WebRequest request) {
    return handlerExceptionInternal(ErrorCodes.MEDIA_TYPE_NOT_ACCEPTABLE_HTTP_ERROR, ex, headers,
        status, request);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
      HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status,
      WebRequest request) {
    return handlerExceptionInternal(ErrorCodes.MEDIA_TYPE_NOT_SUPPORTED_HTTP_ERROR, ex, headers,
        status, request);
  }

  private ResponseEntity<Object> handlerExceptionInternal(ErrorCodes errorCode, Exception ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    ErrorMessage error = new ErrorMessage(errorCode.code(), ex.getMessage());
    ServiceResponse<Void> response = new ServiceResponse<Void>(error);
    return handleExceptionInternal(ex, response, headers, status, request);
  }
}
