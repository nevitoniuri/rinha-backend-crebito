package com.nevitoniuri.rinhabackend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ServiceError {

  CLIENTE_NAO_ENCONTRADO(HttpStatus.NOT_FOUND, "Cliente não encontrado"),
  TIPO_TRANSACAO_INVALIDO(HttpStatus.BAD_REQUEST, "Tipo de transação inválido"),
  ;

  private final HttpStatus httpStatus;
  private final String message;

}
