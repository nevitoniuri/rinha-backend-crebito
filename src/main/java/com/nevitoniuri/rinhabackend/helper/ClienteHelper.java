package com.nevitoniuri.rinhabackend.helper;

import com.nevitoniuri.rinhabackend.controller.response.SaldoResponse;
import com.nevitoniuri.rinhabackend.controller.response.TransacaoResponse;
import com.nevitoniuri.rinhabackend.model.Cliente;
import com.nevitoniuri.rinhabackend.model.Transacao;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteHelper {

  public static TransacaoResponse toTransacaoResponse(Transacao transacao) {
    return TransacaoResponse.builder()
        .valor(transacao.getValor())
        .tipo(transacao.getTipo().name())
        .descricao(transacao.getDescricao())
        .data(transacao.getData().toString())
        .build();
  }

  public static SaldoResponse toSaldoResponse(Cliente cliente) {
    return SaldoResponse.builder()
        .total(cliente.getSaldo())
        .dataExtrato(LocalDateTime.now())
        .limite(cliente.getLimite())
        .build();
  }

}
