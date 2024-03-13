package com.nevitoniuri.rinhabackend.controller;

import com.nevitoniuri.rinhabackend.controller.request.CriarTransacaoRequest;
import com.nevitoniuri.rinhabackend.controller.response.ExtratoResponse;
import com.nevitoniuri.rinhabackend.controller.response.TransacaoResponse;
import com.nevitoniuri.rinhabackend.helper.ClienteHelper;
import com.nevitoniuri.rinhabackend.service.ClienteService;
import com.nevitoniuri.rinhabackend.service.TransacaoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

  private final TransacaoService transacaoService;
  private final ClienteService clienteService;

  @GetMapping("/{id}/extrato")
  public ExtratoResponse getExtrato(@PathVariable Long id) {
    var cliente = clienteService.findByIdOrThrow(id);
    List<TransacaoResponse> ultimasTransacoes = transacaoService.findByClienteId(id)
        .stream().map(ClienteHelper::toTransacaoResponse)
        .toList();
    return ExtratoResponse.builder()
        .saldo(ClienteHelper.toSaldoResponse(cliente))
        .ultimasTransacoes(ultimasTransacoes)
        .build();
  }

  @PostMapping("/{id}/transacoes")
  public void criarTransacao(@RequestBody CriarTransacaoRequest request, @PathVariable Long id) {
    var cliente = clienteService.findByIdOrThrow(id);
    transacaoService.criarTransacao(cliente, request.valor(), request.tipo(), request.descricao());
  }

}
