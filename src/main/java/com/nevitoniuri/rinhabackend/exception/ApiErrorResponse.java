package com.nevitoniuri.rinhabackend.exception;

import lombok.Builder;

@Builder
public class ApiErrorResponse {

  private Integer statusCode;
  private String message;
  private String timestamp;
}