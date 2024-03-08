package com.nevitoniuri.rinhabackend.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record ExtratoResponse(
    SaldoResponse saldo,
    @JsonProperty("ultimas_transacoes")
    List<TransacaoResponse> ultimasTransacoes
) {
}
