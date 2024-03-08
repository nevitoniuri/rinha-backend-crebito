package com.nevitoniuri.rinhabackend.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record SaldoResponse(
    Integer total,
    @JsonProperty("data_extrato")
    LocalDateTime dataExtrato,
    Integer limite
) {

}
