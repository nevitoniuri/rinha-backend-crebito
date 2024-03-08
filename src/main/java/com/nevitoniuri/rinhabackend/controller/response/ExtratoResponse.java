package com.nevitoniuri.rinhabackend.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;

@Builder
public record ExtratoResponse(
    SaldoResponse saldo,
    @JsonProperty("ultimas_transacoes")
    List<TransacaoResponse> ultimasTransacoes
) {
}
