package com.example.pizza_app.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class ErrorHandler {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  public ResponseEntity<?> errorResponse(int statusCode, String msg) {
    ErrorMessage error = new ErrorMessage();
    error.statusCode = statusCode;
    error.message = msg;
    return ResponseEntity.status(statusCode).body(error);
  }
  
  public ResponseEntity<?> errorResponse(int statusCode, String msg, Exception ex) {
    System.out.println(ex.getCause()); 
    return errorResponse(statusCode, msg);
  }


  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ResponseEntity<?> methodNotSupportedHandler(Exception ex) {
    return errorResponse(400, "method not supported");
  }


  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<?> generalErrorHandler(Exception ex) {
    return errorResponse(500, "an Unknown Error has ocurred",ex);
  }


  @ExceptionHandler(NoResourceFoundException.class)
  public ResponseEntity<?> notFoundErrorHandler(Exception ex) {
    return errorResponse(404, "The resource doesn't exists");
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public ResponseEntity<?> missingRequestParameterHandler(Exception ex) {
    return errorResponse(400, ex.getMessage());
  }
}



// Type of response
class ErrorMessage {
  public int statusCode;
  public String message;
}