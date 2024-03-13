package com.nevitoniuri.rinhabackend.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;

@Builder
public record ExtratoResponse(
    @JsonProperty(index = 1)
    SaldoResponse saldo,
    @JsonProperty(index = 2, value = "ultimas_transacoes")
    List<TransacaoResponse> ultimasTransacoes
) {
}
