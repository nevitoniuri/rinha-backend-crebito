package com.nevitoniuri.rinhabackend.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record TransacaoResponse(
    Integer valor,
    String tipo,
    String descricao,
    @JsonProperty("realizada_em")
    String data
) {

}
