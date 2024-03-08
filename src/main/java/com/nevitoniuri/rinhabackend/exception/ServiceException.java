package com.nevitoniuri.rinhabackend.exception;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

  private final ServiceError error;

  public ServiceException(ServiceError error) {
    super(error.getMessage());
    this.error = error;
  }

}
