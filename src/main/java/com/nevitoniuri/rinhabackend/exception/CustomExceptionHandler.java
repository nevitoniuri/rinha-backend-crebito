package com.nevitoniuri.rinhabackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ServiceException.class)
  public ResponseEntity<ApiErrorResponse> handleServiceException(ServiceException ex) {
    HttpStatus httpStatus = ex.getError().getHttpStatus();
    ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
        .statusCode(httpStatus.value())
        .message(ex.getError().getMessage())
        .timestamp(String.valueOf(System.currentTimeMillis()))
        .build();
    return new ResponseEntity<>(apiErrorResponse, httpStatus);
  }
}
