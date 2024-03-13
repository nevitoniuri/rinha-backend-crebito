package com.nevitoniuri.rinhabackend.model.enums;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public enum TipoTransacao {
  CREDITO,
  DEBITO;

  public static TipoTransacao fromString(String tipo) {
    return switch (tipo) {
      case "c" -> CREDITO;
      case "d" -> DEBITO;
      default ->
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tipo de transação inválido");
    };
  }
}
