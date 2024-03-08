package com.nevitoniuri.rinhabackend.model.enums;

import com.nevitoniuri.rinhabackend.exception.ServiceError;
import com.nevitoniuri.rinhabackend.exception.ServiceException;

public enum TipoTransacao {
  DEPOSITO,
  SAQUE;

  public static TipoTransacao fromString(String tipo) {
    return switch (tipo) {
      case "c" -> DEPOSITO;
      case "d" -> SAQUE;
      default -> throw new ServiceException(ServiceError.TIPO_TRANSACAO_INVALIDO);
    };
  }
}
