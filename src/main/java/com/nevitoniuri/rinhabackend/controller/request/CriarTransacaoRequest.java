package com.nevitoniuri.rinhabackend.controller.request;

public record CriarTransacaoRequest(
    Integer valor,
    String tipo,
    String descricao
) {

}
