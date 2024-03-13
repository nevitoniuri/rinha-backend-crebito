package com.nevitoniuri.rinhabackend.model.enums;

public enum TipoTransacao {
  CREDITO,
  DEBITO;

  public static TipoTransacao fromString(String tipo) {
    return switch (tipo) {
      case "c" -> CREDITO;
      case "d" -> DEBITO;
      default -> null;
    };
  }
}
