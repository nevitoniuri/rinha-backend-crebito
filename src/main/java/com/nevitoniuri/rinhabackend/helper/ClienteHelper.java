package com.nevitoniuri.rinhabackend.helper;

import com.nevitoniuri.rinhabackend.controller.response.TransacaoResponse;
import com.nevitoniuri.rinhabackend.model.Transacao;
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

}
